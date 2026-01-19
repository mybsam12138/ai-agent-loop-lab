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
        // stop condition
        if (state.isFinished()) {
            return new ToolCall("finish", Map.of());
        }

        // if we already printed once, finish
        String obs = state.getObservation() == null ? "" : state.getObservation();
        if (obs.startsWith("printed:")) {
            return new ToolCall("finish", Map.of());
        }

        // otherwise print
        return new ToolCall("print", Map.of("message", "Hello from Day 3 tool calling"));
    }
}