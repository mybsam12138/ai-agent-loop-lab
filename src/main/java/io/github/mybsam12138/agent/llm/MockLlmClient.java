package io.github.mybsam12138.agent.llm;

import io.github.mybsam12138.agent.state.AgentPhase;
import io.github.mybsam12138.agent.state.AgentState;
import io.github.mybsam12138.agent.model.ToolCall;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class MockLlmClient implements LlmClient {

    @Override
    public ToolCall decide(AgentState state) {
        switch (state.getPhase()) {

            case START:
                state.setPhase(AgentPhase.RECALL);
                return new ToolCall(
                        "print",
                        Map.of("message", "Agent started with goal: " + state.getGoal())
                );

            case RECALL:
                state.setPhase(AgentPhase.RETRIEVE);
                return new ToolCall(
                        "recall",
                        Map.of("query", state.getGoal())
                );

            case RETRIEVE:
                state.setPhase(AgentPhase.REMEMBER);
                return new ToolCall(
                        "retrieve",
                        Map.of("query", state.getGoal())
                );

            case REMEMBER:
                state.setPhase(AgentPhase.FINISHED);
                return new ToolCall(
                        "remember",
                        Map.of("text", state.getObservation())
                );

            case FINISHED:
                return new ToolCall("finish", Map.of());

            default:
                throw new IllegalStateException("Unknown phase: " + state.getPhase());
        }
    }
}