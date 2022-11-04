package group1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Labeled extends AbstractDecorator {
	
	
	Map<Node, String> nodeToLabel = new HashMap<Node, String>();
	ConcreteGraph graph;
	
	
	public Labeled(Map<Node, String> nodeToLabel, ConcreteGraph graph) {
		super();
		this.graph = graph;
		this.nodeToLabel = nodeToLabel;
	}


	@Override
	public IGraph buildGraph(Node root, List<Edge> edges, Map<Node, String> nodeToLabel, Map<Edge, Integer> nodeToWeight) {
		// TODO Auto-generated method stub
		return new Labeled(nodeToLabel, new ConcreteGraph(edges,root));
	}

	public String getLabel(Node node) {
		return this.nodeToLabel.get(node);
	}

}
