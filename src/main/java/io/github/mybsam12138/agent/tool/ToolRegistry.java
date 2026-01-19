package io.github.mybsam12138.agent.tool;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ToolRegistry {

    private final Map<String, Tool> tools;

    public ToolRegistry(List<Tool> toolList) {
        this.tools = toolList.stream()
                .collect(Collectors.toUnmodifiableMap(Tool::name, Function.identity()));
    }

    public Tool getRequired(String name) {
        Tool tool = tools.get(name);
        if (tool == null) {
            throw new IllegalArgumentException("Unknown tool: " + name + ". Allowed: " + tools.keySet());
        }
        return tool;
    }

    public Map<String, Tool> all() {
        return tools;
    }
}