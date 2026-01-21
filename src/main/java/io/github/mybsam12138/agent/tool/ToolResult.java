package io.github.mybsam12138.agent.tool;

public record ToolResult(
        boolean success,
        String observation,
        String error
) {

    public static ToolResult ok(String observation) {
        return new ToolResult(true, observation, null);
    }

    public static ToolResult fail(String error) {
        return new ToolResult(false, null, error);
    }
}