/**
 * TODO description
 */
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BaseGraph {


	public Set<Node> getAllNodes(){
	Set<Node> nodes = new HashSet<Node>();
	for (Edge edge: this.edges) {
		nodes.add(edge.source);
		nodes.add(edge.target);
	}
	return nodes;
	}
	
	
	private void bfs() {
		Set<Node> alreadySeen = new HashSet<Node>();
		Set<Node> allNodes = this.getAllNodes();
		
		Node currentNode = this.rootNode;
		Set<Node> possibleNextNodes = new HashSet<Node>();
		while (allNodes.size() != alreadySeen.size()) {
			for (Edge edge : this.edges) {
				if (edge.getSource() == currentNode) {
					Node node = edge.getTarget();
					if (!alreadySeen.contains(node)) {
						possibleNextNodes.add(node);
					}
				}
			}
			alreadySeen.add(currentNode);
			currentNode = possibleNextNodes.iterator().next();
			possibleNextNodes.remove(currentNode);
		}
	}

	public void traverse() {
		this.bfs();
	}


}