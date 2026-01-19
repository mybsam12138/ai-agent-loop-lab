package io.github.mybsam12138.agent.llm;

import io.github.mybsam12138.agent.model.AgentState;
import io.github.mybsam12138.agent.model.ToolCall;

public interface LlmClient {
    ToolCall decide(AgentState state);
}