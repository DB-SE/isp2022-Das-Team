import java.util.ArrayList;
import java.util.List; 
import java.util.Map; 

/**
 * TODO description
 */
public class Main {
	
	public static void main(String[] args) {
		
		
		List<Node> nodes = new ArrayList<Node>();
		List<Edge> edges = new ArrayList<Edge>();;
		Node root = nodes.get(0);
		
		BaseGraph graph = new BaseGraph(edges, root);
		
		graph.traverse();

		
		
		
	}

}