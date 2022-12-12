package interfaces;

import java.util.List;
import java.util.Map;

import src.ConcreteGraph;
import src.Edge;
import src.IGraph;
import src.Node;

//Mst, Export Adjacency
public interface IGraphAlgo {
	
	//FixMe: probably better to handle them in separate interfaces ?
	ConcreteGraph mst();
	int[][] getAdjacencyMatrix ();

}
