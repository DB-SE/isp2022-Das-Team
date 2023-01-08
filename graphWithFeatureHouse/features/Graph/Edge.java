/**
 * TODO description
 */
public class Edge {
	
	Node source;
	Node target;
	
	public Edge(Node node1, Node node2) {
		this.source = node1;
		this.target = node2;
	}

	public Node getSource() {
		return source;
	}

	public void setSource(Node node) {
		this.source = node;
	}

	public Node getTarget() {
		return target;
	}

	public void setTarget(Node node2) {
		this.target = node2;
	}

	
	
}
