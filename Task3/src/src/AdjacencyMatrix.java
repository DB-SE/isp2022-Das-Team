package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import interfaces.IGraphAlgo;

/**
 * TODO description
 */
public class AdjacencyMatrix extends AbstractDecorator implements IGraphAlgo {

	int[][] adjacencyMatrix;
	ConcreteGraph graph;
	Map<Edge, Integer> nodeToWeight;

	public AdjacencyMatrix(List<Edge> edges, Map<Edge, Integer> nodeToWeight, ConcreteGraph graph) {
		this.adjacencyMatrix = this.createMatrix(edges);
		this.graph = graph;
		this.nodeToWeight = nodeToWeight;
	}

	@Override
	public IGraph buildGraph(Node root, List<Edge> edges, Map<Node, String> nodeToLabel,
			Map<Edge, Integer> nodeToWeight) {
		// TODO Auto-generated method stub
		return new AdjacencyMatrix(edges, nodeToWeight, new ConcreteGraph(edges, root));
	}

	private int[][] createMatrix(List<Edge> edges) {
		List<Node> nodes = this.amountOfNodes(edges);
		int amountNodes = nodes.size();
		int[][] adjacencyMatrix = new int[amountNodes][amountNodes];

		int i = 0;
		int j = 0;
		for (Node node : nodes) {
			for (Node otherNode : nodes) {
				adjacencyMatrix[i][j] = 0;
				
				// #if Weighted
				for (Edge edge : edges) {
					if (node.equals(edge.getSource())) {
						adjacencyMatrix[i][j] = this.nodeToWeight.get(edge);
					}
					if (otherNode.equals(edge.getTarget())) {
						adjacencyMatrix[i][j] = this.nodeToWeight.get(edge);
					}
					// #if Directed
					if (otherNode.equals(edge.getSource())) {
						adjacencyMatrix[i][j] = this.nodeToWeight.get(edge);
					}
					if (node.equals(edge.getTarget())) {
						adjacencyMatrix[i][j] = this.nodeToWeight.get(edge);
					}
					// #endif
				}
				// #else
//@				for (Edge edge : edges) {
//@					if (node.equals(edge.getSource())) {
//@						adjacencyMatrix[i][j] = 1;
//@					}
//@					if (otherNode.equals(edge.getTarget())) {
//@						adjacencyMatrix[i][j] = 1;
//@					}
					// #if Directed
//@					if (otherNode.equals(edge.getSource())) {
//@						adjacencyMatrix[i][j] = 1;
//@					}
//@					if (node.equals(edge.getTarget())) {
//@						adjacencyMatrix[i][j] = 1;
//@					}
					// #endif
//@					
//@				}
				// #endif
				j++;
			}
			i++;
		}
		return adjacencyMatrix;
	}

	private List<Node> amountOfNodes(List<Edge> edges) {
		List<Node> nodes = new ArrayList<>();
		for (Edge edge : edges) {
			if (!nodes.contains(edge.target)) {
				nodes.add(edge.target);
			}
			if (!nodes.contains(edge.source)) {
				nodes.add(edge.source);
			}
		}
		return nodes;
	}
	
	
	public int[][] getAdjacencyMatrix () {
		return this.adjacencyMatrix;
	}

	
	//ToDo: throw sth here to not return null
	@Override
	public ConcreteGraph mst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDirected() {
		// TODO Auto-generated method stub
		return false;
	}

}
