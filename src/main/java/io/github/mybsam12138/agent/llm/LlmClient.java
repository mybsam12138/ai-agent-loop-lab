package io.github.mybsam12138.agent.llm;

import io.github.mybsam12138.agent.model.Action;
import io.github.mybsam12138.agent.model.AgentState;

public interface LlmClient {

    Action decide(AgentState state);
}