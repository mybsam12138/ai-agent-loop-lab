package io.github.mybsam12138.agent.state;

public enum AgentPhase {
    START,        // initial print
    RECALL,       // try long-term memory
    RETRIEVE,     // external retrieval if needed
    REMEMBER,     // store new knowledge
    FINISHED
}