import java.util.List;

/**
 * TODO description
 */
public class BaseGraph {
	
	List<Edge> edges;
	Node rootNode;
	
	public BaseGraph(List<Edge> edges, Node rootNode) {
		this.edges = edges;
		this.rootNode = rootNode;
	}

}