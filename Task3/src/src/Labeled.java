package src;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interfaces.IAttribute;

public class Labeled extends AbstractDecorator implements IAttribute {
	
	Map<Node, String> nodeToLabel = new HashMap<Node, String>();
	ConcreteGraph graph;
	
	public Labeled(Map<Node, String> nodeToLabel, ConcreteGraph graph) {
		super();
		this.graph = graph;
		this.nodeToLabel = nodeToLabel;
	}

	@Override
	public IGraph buildGraph(Node root, List<Edge> edges, Map<Node, String> nodeToLabel, Map<Edge, Integer> nodeToWeight) {
		// #if Labeled
		return new Labeled(nodeToLabel, new ConcreteGraph(edges,root));
		// #else
//@		return new ConcreteGraph(edges,root);
	// #endif
	}

	public String getLabel(Node node) {
		return this.nodeToLabel.get(node);
	}

	@Override
	public Object getData(Object inputData) {
		return this.getLabel((Node)inputData);
	}

}
