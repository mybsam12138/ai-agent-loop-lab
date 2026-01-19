package io.github.mybsam12138.agent.model;

import io.github.mybsam12138.agent.memory.Memory;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AgentState {
    private final String goal;
    private String observation;
    private boolean finished;
    private final Memory memory;

    public void remember(String entry) {
        memory.add(entry);
    }

    public List<String> memoryHistory() {
        return memory.history();
    }
}