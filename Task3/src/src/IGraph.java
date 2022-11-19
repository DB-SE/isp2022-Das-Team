package src;

import java.util.List;
import java.util.Map;

public interface IGraph {
	
	public IGraph buildGraph(Node root, List<Edge> edges, Map<Node, String> nodeToLabel, Map<Edge, Integer> nodeToWeight);

}
