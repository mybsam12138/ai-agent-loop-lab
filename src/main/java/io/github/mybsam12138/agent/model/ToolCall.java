package io.github.mybsam12138.agent.model;

import java.util.Map;

public record ToolCall(String name, Map<String, Object> arguments) {
    public ToolCall {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("ToolCall.name must not be blank");
        }
        arguments = (arguments == null) ? Map.of() : Map.copyOf(arguments);
    }
}