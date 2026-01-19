package io.github.mybsam12138.agent.memory;

import java.util.ArrayList;
import java.util.List;

public class InMemoryMemory implements Memory {

    private final List<String> entries = new ArrayList<>();

    @Override
    public void add(String entry) {
        entries.add(entry);
    }

    @Override
    public List<String> history() {
        return List.copyOf(entries);
    }
}