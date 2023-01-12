/**
 * TODO description
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BaseGraph {
	
	Map<Edge, Integer> edgeToWeight;
	

	public BaseGraph mst() {
		List<Edge> edges = new ArrayList<Edge>();
		Set<Node> alreadySeen = new HashSet<Node>();
		Set<Node> allNodes = this.getAllNodes();
		Node currentNode = this.rootNode;
		Set<Edge> possibleNextEdges = new HashSet<Edge>();

		while (allNodes.size() != alreadySeen.size()) {
			for (Edge edge : this.edges) {
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
		BaseGraph mst = new BaseGraph (edges, this.rootNode);	
		return mst;
	}

	
}
