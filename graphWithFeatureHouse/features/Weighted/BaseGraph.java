/**
 * TODO description
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseGraph {
	
	Map<Edge, Integer> nodeToWeight = new HashMap<Edge, Integer>();
		
		
	public int getWeight(Edge edge) {
		return this.nodeToWeight.containsKey(edge)?nodeToWeight.get(edge):0;
	}


}
