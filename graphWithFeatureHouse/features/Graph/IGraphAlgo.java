/**
 * TODO description
 */
import java.util.List;
import java.util.Map;

//Mst, Export Adjacency
public interface IGraphAlgo {
	
	ConcreteGraph mst();
	int[][] getAdjacencyMatrix ();
	boolean isDirected();

}
