package io.github.mybsam12138.agent.runner;

import io.github.mybsam12138.agent.loop.AgentLoop;
import io.github.mybsam12138.agent.memory.InMemoryMemory;
import io.github.mybsam12138.agent.state.AgentPhase;
import io.github.mybsam12138.agent.state.AgentState;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AgentRunner implements CommandLineRunner {

    private final AgentLoop agentLoop;

    @Override
    public void run(String... args) {
        AgentState state = new AgentState(
                "Demonstrate a minimal agent loop",
                "start",false,new InMemoryMemory(), AgentPhase.START
        );
        agentLoop.run(state);
    }
}