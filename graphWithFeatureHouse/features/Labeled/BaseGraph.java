/**
 * TODO description
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseGraph {
	
	Map<Node, String> nodeToLabel = new HashMap<Node, String>();
	
	public BaseGraph(Map<Node, String> nodeToLabel, List<Edge> edges, Node rootNode) {
			this.edges = edges;
			this.rootNode = rootNode;
		this.nodeToLabel = nodeToLabel;
	}


	public String getLabel(Node node) {
		return this.nodeToLabel.get(node);
	}

}
