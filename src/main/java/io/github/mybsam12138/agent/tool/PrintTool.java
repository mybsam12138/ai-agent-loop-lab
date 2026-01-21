package io.github.mybsam12138.agent.tool;

import io.github.mybsam12138.agent.state.AgentState;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class PrintTool implements Tool {

    @Override
    public String name() {
        return "print";
    }

    @Override
    public String execute(Map<String, Object> args, AgentState state) {
        Object msg = args.get("message");
        String message = (msg == null) ? "" : String.valueOf(msg);

        System.out.println(message);

        // Update observation so the loop/LLM can react.
        state.setObservation("printed: " + message);
        return state.getObservation();
    }
}