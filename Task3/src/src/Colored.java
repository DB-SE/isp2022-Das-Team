package src;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO description
 */
public class Colored extends AbstractDecorator { 

	Map<Node, String> nodeToColor = new HashMap<Node, String>();
	ConcreteGraph graph;
	
	public Colored (Map<Node, String> nodeToColor, ConcreteGraph graph) {
		super();
		this.graph = graph;
		this.nodeToColor = nodeToColor;
	}
	
	@Override
	public IGraph buildGraph(Node root, List<Edge> edges, Map<Node, String> nodeToColor, Map<Edge, Integer> nodeToWeight) {
		// #if Colored
		return new Colored(nodeToColor, new ConcreteGraph(edges,root));
		// #else
//@		return new ConcreteGraph(edges,root);
	// #endif
	}
	
	public String getColor(Node node) {
		return this.nodeToColor.get(node);
	}
}