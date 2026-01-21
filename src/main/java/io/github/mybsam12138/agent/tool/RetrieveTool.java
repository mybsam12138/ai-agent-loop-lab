package io.github.mybsam12138.agent.tool;

import io.github.mybsam12138.agent.state.AgentState;
import io.github.mybsam12138.agent.rag.Retriever;
import io.github.mybsam12138.agent.rag.StaticRetriever;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class RetrieveTool implements Tool {

    private final Retriever retriever = new StaticRetriever();

    @Override
    public String name() {
        return "retrieve";
    }

    @Override
    public String execute(Map<String, Object> args, AgentState state) {

        String query = String.valueOf(args.get("query"));
        List<String> docs = retriever.retrieve(query);

        String knowledge = String.join("\n", docs);

        // Inject into observation, NOT memory
        state.setObservation("retrieved knowledge:\n" + knowledge);

        return state.getObservation();
    }
}