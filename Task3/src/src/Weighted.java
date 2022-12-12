package src;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interfaces.IAttribute;

public class Weighted extends AbstractDecorator implements IAttribute {
	
	Map<Edge, Integer> nodeToWeight = new HashMap<Edge, Integer>();
	ConcreteGraph  graph;

	
	public Weighted(Map<Edge, Integer> nodeToWeight, ConcreteGraph  graph) {
		super();
		this.nodeToWeight = nodeToWeight;
		this.graph = graph;
	}



	public IGraph buildGraph(Node root, List<Edge> edges, Map<Node, String> nodeToLabel, Map<Edge, Integer> nodeToWeight) {
		// #if Weighted
		return new Weighted(nodeToWeight, new ConcreteGraph(edges,root));
		// #else
//@		return new ConcreteGraph(edges,root);
	// #endif
	}

	
	public int getWeight(Edge edge) {
		return this.nodeToWeight.containsKey(edge)?nodeToWeight.get(edge):0;
	}


	@Override
	public Object getData(Object inputData) {
		return this.getWeight((Edge)inputData);
	}



}
