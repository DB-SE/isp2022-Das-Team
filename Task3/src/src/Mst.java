package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import interfaces.IGraphAlgo;

public class Mst extends AbstractDecorator implements IGraphAlgo {
	
	
	ConcreteGraph graph;
	Map<Edge, Integer> edgeToWeight;
	
	public  Mst (Map<Edge, Integer> edgeToWeight,ConcreteGraph graph) {
		super();
		this.edgeToWeight = edgeToWeight;
		this.graph = graph;
	}
	
	
	@Override
	public IGraph buildGraph(Node root, List<Edge> edges, Map<Node, String> nodeToLabel, Map<Edge, Integer> nodeToWeight) {
		if (nodeToWeight.equals(null)) {
			return new ConcreteGraph(edges,root);
		}
		// #if Mst
//@		return new Mst(nodeToWeight, new ConcreteGraph(edges,root));
		// #else
		return new ConcreteGraph(edges,root);
	// #endif
	}


	public ConcreteGraph mst() {
		List<Edge> edges = new ArrayList<Edge>();
		Set<Node> alreadySeen = new HashSet<Node>();
		Set<Node> allNodes = this.graph.getAllNodes();
		Node currentNode = this.graph.rootNode;
		Set<Edge> possibleNextEdges = new HashSet<Edge>();

		while (allNodes.size() != alreadySeen.size()) {
			for (Edge edge : this.graph.edges) {
				if (edge.getSource() == currentNode) {
					possibleNextEdges.add(edge);
				}
			}
			alreadySeen.add(currentNode);
			Edge nextEdge = null;
			int value = 0;
			for (Edge edge :possibleNextEdges) {
				if (value<edgeToWeight.get(edge)) {
					currentNode = edge.getTarget();
					if (alreadySeen.contains(currentNode)) {
					value = edgeToWeight.get(edge);
					nextEdge = edge;
					}
				}
			}
			edges.add(nextEdge);
			possibleNextEdges.remove(nextEdge);
		}
		ConcreteGraph mst = new ConcreteGraph (edges, this.graph.rootNode);	
		return mst;
	}


	@Override
	public int[][] getAdjacencyMatrix() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isDirected() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
