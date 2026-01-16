package io.github.mybsam12138.agent.loop;

import io.github.mybsam12138.agent.llm.LlmClient;
import io.github.mybsam12138.agent.model.Action;
import io.github.mybsam12138.agent.model.AgentState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AgentLoop {

    private final LlmClient llmClient;

    public void run(AgentState state) {

        while (!state.isFinished()) {
            System.out.println("Observation: " + state.getObservation());
            Action action = llmClient.decide(state);
            System.out.println("Action decided: " + action);

            switch (action) {
                case PRINT -> state.setObservation("done");
                case FINISH -> state.setFinished(true);
            }
        }
    }
}