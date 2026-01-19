package io.github.mybsam12138.agent.tool;

import io.github.mybsam12138.agent.model.AgentState;
import java.util.Map;

public interface Tool {
    String name();

    /**
     * Execute the tool and update AgentState as needed.
     * Return a short observation string (optional but useful for debugging).
     */
    String execute(Map<String, Object> args, AgentState state);
}