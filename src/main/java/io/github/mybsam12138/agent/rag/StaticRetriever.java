package io.github.mybsam12138.agent.rag;

import java.util.List;

public class StaticRetriever implements Retriever {

    @Override
    public List<String> retrieve(String query) {
        // Demo-only: pretend this is a document store
        return List.of(
            "RAG stands for Retrieval-Augmented Generation.",
            "RAG injects external knowledge into LLM reasoning.",
            "RAG does not replace memory."
        );
    }
}