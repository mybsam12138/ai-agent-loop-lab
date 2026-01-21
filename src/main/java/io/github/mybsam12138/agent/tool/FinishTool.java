package io.github.mybsam12138.agent.tool;

import io.github.mybsam12138.agent.state.AgentState;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class FinishTool implements Tool {

    @Override
    public String name() {
        return "finish";
    }

    @Override
    public String execute(Map<String, Object> args, AgentState state) {
        state.setFinished(true);
        state.setObservation("finished");
        return "finished";
    }
}