package io.github.mybsam12138.agent.llm;

import io.github.mybsam12138.agent.model.AgentState;
import io.github.mybsam12138.agent.model.ToolCall;
import java.awt.Desktop.Action;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class MockLlmClient implements LlmClient {

    @Override
    public ToolCall decide(AgentState state) {
        // 1. First step: print something
        if (state.memoryHistory().isEmpty() && state.getObservation().equals("start")) {
            return new ToolCall(
                    "print",
                    Map.of("message", "Starting agent with goal: " + state.getGoal())
            );
        }

        // 2. After printing, remember it
        if (state.memoryHistory().isEmpty()) {
            return new ToolCall(
                    "remember",
                    Map.of("text", state.getObservation())
            );
        }

        // 3. Recall memory once
        if (!state.getObservation().startsWith("memory")) {
            return new ToolCall("recall", Map.of());
        }

        // 4. Finish
        return new ToolCall("finish", Map.of());
    }
}