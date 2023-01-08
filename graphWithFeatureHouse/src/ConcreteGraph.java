/**
 * TODO description
 */
import java.util.ArrayList; 
import java.util.HashSet; 
import java.util.List; 
import java.util.Map; 
import java.util.Set; 

public  class  ConcreteGraph  implements IGraph {
	
	
	List<Edge> edges;

	
	Node rootNode;

	

	public ConcreteGraph(List<Edge> edges, Node rootNode) {
		this.edges = edges;
		this.rootNode = rootNode;
	}

	

	
	public IGraph buildGraph(Node root, List<Edge> edges, Map<Node, String> nodeToLabel, Map<Edge, Integer> nodeToWeight) {
			
		return new ConcreteGraph(edges,root);
	}

	

	
	public Set<Node> getAllNodes(){
	Set<Node> nodes = new HashSet<Node>();
	for (Edge edge: this.edges) {
		nodes.add(edge.source);
		nodes.add(edge.target);
	}
	return nodes;
	}


}
