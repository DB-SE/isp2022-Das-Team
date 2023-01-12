/**
 * TODO description
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BaseGraph {
	

	public void dfs() {

		Set<Node> alreadySeen = new HashSet<Node>();
		Set<Node> allNodes = this.graph.getAllNodes();
		Node currentNode = this.graph.rootNode;
		Node nextCurNode = null;
		List<Node> possibleNextNodes = new ArrayList<Node>();
		boolean isLeaf = true;

		while (allNodes.size() != alreadySeen.size()) {
			for (Edge edge : this.graph.edges) {
				if (edge.getSource() == currentNode) {
					isLeaf = false;
					Node node = edge.getTarget();
					if (!alreadySeen.contains(node) && nextCurNode!=null) {
						possibleNextNodes.add(node);
					}
					nextCurNode = node;
				}
			}
			alreadySeen.add(currentNode);
			if (isLeaf) {
				currentNode = possibleNextNodes.iterator().next();
			}
			else {
				currentNode = nextCurNode;
			}
			possibleNextNodes.remove(currentNode );
			nextCurNode = null;
		}
	}
	
	public void traverse() {
		this.dfs();
	}

}
