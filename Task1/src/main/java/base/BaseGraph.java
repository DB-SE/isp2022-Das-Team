package base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BaseGraph implements IGraph {

    private final List<Node> nodes;
    private final List<Edge> edges;
    private final Map<Node, Node> nodeConnections = new HashMap<>();


    public BaseGraph(List<Node> nodes, List<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
        nodes.forEach(x -> x.initConnectionsList(edges));
        this.edges.forEach(x -> this.nodeConnections.put(x.getSource(), x.getTarget()));
    }


    public List<Node> getNodes() {
        return this.nodes;
    }

    public List<Edge> getEdges() {
        return this.edges;
    }

    public Map<Node, Node> getNodeConnections() {
        return this.nodeConnections;
    }


    @Override
    public List<Node> depthSearch(Node node, Node curNode, Set<Node> passedNodes, List<Node> curPath) {
        throw new NotImplementedException();
    }

    @Override
    public BaseGraph findMst() {
        throw new NotImplementedException();
    }

    private static List<Node> findAllRoots(BaseGraph graph) {
        List<Node> rootNodes = graph.getNodes();
        for (Map.Entry<Node, Node> entry : graph.nodeConnections.entrySet()) {
            Node targetNode = entry.getValue();
            rootNodes.remove(targetNode);
        }
        return rootNodes;
    }

}
