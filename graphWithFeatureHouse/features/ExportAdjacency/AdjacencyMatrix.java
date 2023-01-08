/**
 * TODO description
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AdjacencyMatrix implements IGraphAlgo, IGraph {

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
		Set<Node> nodes = this.getTheNodes(edges);
		int amountNodes = nodes.size();
		int[][] adjacencyMatrix = new int[amountNodes][amountNodes];

		int i = 0;
		int j = 0;
		for (Node node : nodes) {
			for (Node otherNode : nodes) {
				adjacencyMatrix[i][j] = 0;
				
				for (Edge edge : edges) {
					if (node.equals(edge.getSource())) {
						adjacencyMatrix[i][j] = this.nodeToWeight.get(edge);
					}
					if (otherNode.equals(edge.getTarget())) {
						adjacencyMatrix[i][j] = this.nodeToWeight.get(edge);
					}
					if (otherNode.equals(edge.getSource())) {
						adjacencyMatrix[i][j] = this.nodeToWeight.get(edge);
					}
					if (node.equals(edge.getTarget())) {
						adjacencyMatrix[i][j] = this.nodeToWeight.get(edge);
					}
				}
				j++;
			}
			i++;
		}
		return adjacencyMatrix;
	}
	
	private Set<Node> getTheNodes () {
		Set<Node> theNodes = new HashSet<Node>();
		for (Edge edge : edges) {
			if (!theNodes.contains(edge.target)) {
				theNodes.add(edge.target);
			}
			if (!theNodes.contains(edge.source)) {
				theNodes.add(edge.source);
			}
		}
		return theNodes;
	}
	
	


public int[][] getAdjacencyMatrix () {
	return this.adjacencyMatrix;
}
	
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
