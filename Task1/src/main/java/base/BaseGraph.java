package base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import features.WeightedNode;

public class BaseGraph implements IGraph {

    private final List<? extends Node> nodes;
    private final Map<UUID, Node> idToNode;

    public BaseGraph(List<Node> nodes) {
        this.nodes = nodes;
        this.idToNode = new HashMap<>();
        this.nodes.forEach(x->this.idToNode.put(x.getId(),x));
    }
    
    public BaseGraph(BaseGraph graph) {
        this.nodes = graph.getNodes();
        this.idToNode = graph.getIdToNode();
    }

    public List<? extends Node> getNodes() {
        return this.nodes;
    }
    
    public Map<UUID, Node> getIdToNode(){
    	return this.idToNode;
    }
    
    public Node getNodeById(UUID iD) {
    	return this.idToNode.get(iD);
    }

    @Override
    public List<Node> depthSearch(Node startNode, Node node) {
        throw new NotImplementedException();
    }

    @Override
    public List<WeightedNode> findMst() {
        throw new NotImplementedException();
    }
    
}
