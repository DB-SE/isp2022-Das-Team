package base;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IGraph {


    List<Node> depthSearch(Node node, Node curNode, Set<Node> passedNodes, List<Node> curPath);

    BaseGraph findMst();

}
