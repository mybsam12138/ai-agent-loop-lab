package io.github.mybsam12138.agent.tool;

import io.github.mybsam12138.agent.state.AgentState;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class RecallTool implements Tool {

    @Override
    public String name() {
        return "recall";
    }

    @Override
    public String execute(Map<String, Object> args, AgentState state) {
        String memory = state.memoryHistory().stream()
                .collect(Collectors.joining("\n"));
        state.setObservation("memory:\n" + memory);
        return state.getObservation();
    }
}