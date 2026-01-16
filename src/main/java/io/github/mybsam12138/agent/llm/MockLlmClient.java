package io.github.mybsam12138.agent.llm;

import io.github.mybsam12138.agent.model.Action;
import io.github.mybsam12138.agent.model.AgentState;
import org.springframework.stereotype.Component;

@Component
public class MockLlmClient implements LlmClient {

    @Override
    public Action decide(AgentState state) {
        if (state.getObservation().contains("done")) {
            return Action.FINISH;
        }
        return Action.PRINT;
    }
}