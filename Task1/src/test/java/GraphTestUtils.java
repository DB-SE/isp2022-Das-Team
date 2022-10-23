import java.util.Collection;
import java.util.List;
import base.BaseGraph;
import base.Node;

public class GraphTestUtils {

    public static void printNodes(Collection<? extends Node> nodes){
        System.out.print("Path__: ");
        for (Node node : nodes) {
            System.out.print(node.getLabel() + " ");
        }
    }
    
    public static int sumWeightsOfMst(List<? extends Node> mst) {
    	int sum = 0;
    	for (Node node : mst) {
    		sum += node.getNeighbors().values().stream().mapToInt(Integer::intValue).sum();
    	}
        System.out.println("\nSum of Mst: "+sum/2);
        return sum/2;
    }
}
