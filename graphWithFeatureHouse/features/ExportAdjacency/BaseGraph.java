/**
 * TODO description
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BaseGraph {
	
	int[][] adjacencyMatrix;
	Map<Edge, Integer> nodeToWeight;

	
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


}
