package src;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dfs extends AbstractDecorator {

	ConcreteGraph graph;

	public Dfs(ConcreteGraph graph) {
		super();
		this.graph = graph;
	}

	@Override
	public IGraph buildGraph(Node root, List<Edge> edges, Map<Node, String> nodeToLabel,
			Map<Edge, Integer> nodeToWeight) {
		// #if Dfs
//@		return new Dfs(new ConcreteGraph(edges, root));
		// #else
		return new ConcreteGraph(edges,root);
	// #endif
	}

	public void dfs() {

		Set<Node> alreadySeen = new HashSet<Node>();
		Set<Node> allNodes = this.graph.getAllNodes();
		Node currentNode = this.graph.rootNode;
		Set<Node> possibleNextNodes = new HashSet<Node>();

		while (allNodes.size() != alreadySeen.size()) {
			for (Edge edge : this.graph.edges) {
				if (edge.getSource() == currentNode) {
					Node node = edge.getTarget();
					if (!alreadySeen.contains(node)) {
						possibleNextNodes.add(node);
					}
				}
			}
			alreadySeen.add(currentNode);
			currentNode = possibleNextNodes.iterator().next();
			possibleNextNodes.remove(currentNode );
		}
	}

}
