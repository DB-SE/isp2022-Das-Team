package interfaces;

import java.util.List;
import java.util.Map;

import src.ConcreteGraph;
import src.Edge;
import src.IGraph;
import src.Node;

public interface IGraphAlgo {
	
	ConcreteGraph mst();
	int[][] getAdjacencyMatrix ();
	boolean isDirected();

}
