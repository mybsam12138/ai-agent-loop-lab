package io.github.mybsam12138.agent.memory;

import java.util.List;

public interface Memory {
    void add(String entry);
    List<String> history();
}
