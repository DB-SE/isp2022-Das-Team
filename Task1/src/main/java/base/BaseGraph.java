package base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BaseGraph implements IGraph {

    private final List<Node> nodes;
    private final Map<Node, Node> nodeConnections = new HashMap<>();


    public BaseGraph(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return this.nodes;
    }

    @Override
    public List<Node> depthSearch(Node node) {
        throw new NotImplementedException();
    }

    @Override
    public List<Node> findMst() {
        throw new NotImplementedException();
    }
    
    
    //Todo: refactor
//  public boolean isGraphConnected() {
//  boolean bool = true;
//  for (Node node : this.getNodes()) {
//      bool = bool && !node.getNeighbors().isEmpty();
//  }
//  return bool;
//}
    
}
