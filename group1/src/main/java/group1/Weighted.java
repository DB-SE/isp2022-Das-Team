package group1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Weighted extends AbstractDecorator {
	
	Map<Edge, Integer> nodeToWeight = new HashMap<Edge, Integer>();
	ConcreteGraph  graph;

	
	public Weighted(Map<Edge, Integer> nodeToWeight, ConcreteGraph  graph) {
		super();
		this.nodeToWeight = nodeToWeight;
		this.graph = graph;
	}



	public IGraph buildGraph(Node root, List<Edge> edges, Map<Node, String> nodeToLabel, Map<Edge, Integer> nodeToWeight) {
		// TODO Auto-generated method stub
		return new Weighted(nodeToWeight, new ConcreteGraph(edges,root));
	}

	
	public int getWeight(Edge edge) {
		return this.nodeToWeight.containsKey(edge)?nodeToWeight.get(edge):0;
	}
	

}
