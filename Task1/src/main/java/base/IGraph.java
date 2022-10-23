package base;

import java.util.List;

import features.WeightedNode;

public interface IGraph {
	
    List<Node> depthSearch(Node startNode, Node node);

    List<WeightedNode> findMst();

}
