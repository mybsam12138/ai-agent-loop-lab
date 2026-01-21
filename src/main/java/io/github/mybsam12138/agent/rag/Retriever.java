package io.github.mybsam12138.agent.rag;

import java.util.List;

public interface Retriever {
    List<String> retrieve(String query);
}