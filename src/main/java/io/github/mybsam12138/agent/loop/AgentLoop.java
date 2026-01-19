package io.github.mybsam12138.agent.loop;

import io.github.mybsam12138.agent.llm.LlmClient;
import io.github.mybsam12138.agent.model.AgentState;
import io.github.mybsam12138.agent.model.ToolCall;
import io.github.mybsam12138.agent.tool.Tool;
import io.github.mybsam12138.agent.tool.ToolRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AgentLoop {

    private final LlmClient llmClient;
    private final ToolRegistry toolRegistry;

    public void run(AgentState state) {

        while (!state.isFinished()) {
            System.out.println("Goal: " + state.getGoal());
            System.out.println("Observation: " + state.getObservation());

            ToolCall call = llmClient.decide(state);
            System.out.println("ToolCall: " + call.name() + " " + call.arguments());

            Tool tool = toolRegistry.getRequired(call.name());
            String toolResultObservation = tool.execute(call.arguments(), state);

            // optional extra debug
            System.out.println("ToolResultObservation: " + toolResultObservation);
            System.out.println("Memory: " + state.memoryHistory());
            System.out.println("----");
        }
    }
}