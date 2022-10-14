package features;

import base.BaseGraph;
import base.IGraph;
import base.Node;

import java.util.List;
import java.util.Set;

public class DepthSearchAndMst extends GraphFeatureComponent {


    public DepthSearchAndMst(BaseGraph graph) {
        super(graph);
    }

    @Override
    public List<Node> depthSearch(Node node, Node curNode, Set<Node> passedNodes, List<Node> curPath) {
        System.out.println("works");
        return null;
    }

    @Override
    public BaseGraph findMst() {
        System.out.println("works");
        return null;
    }


}
