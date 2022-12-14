package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import interfaces.ITraverseGraph;

public class Dfs extends AbstractDecorator  implements ITraverseGraph {

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
	
	@Override
	public void traverse() {
		this.dfs();
	}

}
