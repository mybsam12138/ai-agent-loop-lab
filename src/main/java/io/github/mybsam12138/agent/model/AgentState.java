package io.github.mybsam12138.agent.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AgentState {
    private final String goal;
    private String observation;
    private boolean finished;
}