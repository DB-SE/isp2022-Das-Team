/**
 * TODO description
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * TODO description
 */
public class BaseGraph { 

	Map<Node, String> nodeToColor = new HashMap<Node, String>();
	
	public String getColor(Node node) {
		return this.nodeToColor.get(node);
	}

}