/**
 * TODO description
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * TODO description
 */
public class Colored implements IAttribute , IGraph { 

	Map<Node, String> nodeToColor = new HashMap<Node, String>();
	ConcreteGraph graph;
	
	public Colored (Map<Node, String> nodeToColor, ConcreteGraph graph) {
		super();
		this.graph = graph;
		this.nodeToColor = nodeToColor;
	}
	
	@Override
	public IGraph buildGraph(Node root, List<Edge> edges, Map<Node, String> nodeToColor, Map<Edge, Integer> nodeToWeight) {
		return new Colored(nodeToColor, new ConcreteGraph(edges,root));
	}
	
	public String getColor(Node node) {
		return this.nodeToColor.get(node);
	}

	@Override
	public Object getData(Object inputData) {
		return this.getColor((Node)inputData);
	}
}