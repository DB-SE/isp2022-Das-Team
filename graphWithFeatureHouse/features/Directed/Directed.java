/**
 * TODO description
 */
import java.util.List;
import java.util.Map;

public class Directed  implements IGraphAlgo , IGraph {
	
	ConcreteGraph graph;
	
	public Directed(ConcreteGraph graph) {
		super();
		this.graph = graph;
	}


	@Override
	public IGraph buildGraph(Node root, List<Edge> edges, Map<Node, String> nodeToLabel, Map<Edge, Integer> nodeToWeight) {
		// TODO Auto-generated method stub
		return new Directed(new ConcreteGraph(edges, root));
	}


	@Override
	public ConcreteGraph mst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[][] getAdjacencyMatrix() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isDirected() {
		// TODO Auto-generated method stub
		return true;
	}

}


