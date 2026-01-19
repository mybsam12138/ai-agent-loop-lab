package io.github.mybsam12138.agent.tool;

import io.github.mybsam12138.agent.model.AgentState;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class RememberTool implements Tool {

    @Override
    public String name() {
        return "remember";
    }

    @Override
    public String execute(Map<String, Object> args, AgentState state) {
        String text = String.valueOf(args.get("text"));
        state.remember(text);
        state.setObservation("remembered: " + text);
        return state.getObservation();
    }
}