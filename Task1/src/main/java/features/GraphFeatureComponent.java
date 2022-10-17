package features;

import base.BaseGraph;
import base.IGraph;

public abstract class GraphFeatureComponent implements IGraph {

    protected BaseGraph graph;

    public GraphFeatureComponent(BaseGraph graph) {
        this.graph = graph;
    }

    public BaseGraph getGraph() {
        return graph;
    }
    
}
