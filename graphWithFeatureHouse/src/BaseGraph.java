
import java.util.List; /**
 * TODO description
 */
import java.util.HashMap; 
import java.util.Map; /**
 * TODO description
 */
import java.util.ArrayList; /**
 * TODO description
 */
import java.util.HashSet; 
import java.util.Set; 

public   class  BaseGraph {
	
	
	List<Edge> edges;

	
	Node rootNode;

	
	
	public BaseGraph(List<Edge> edges, Node rootNode) {
		this.edges = edges;
		this.rootNode = rootNode;
	}

	
	
	Map<Edge, Integer> nodeToWeight = new HashMap<Edge, Integer>();

	
		
		
	public int getWeight(Edge edge) {
		return this.nodeToWeight.containsKey(edge)?nodeToWeight.get(edge):0;
	}

	
	

	public boolean isDirected() {
		return true;
	}

	
	
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
