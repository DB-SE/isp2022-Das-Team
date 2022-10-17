import java.util.List;

import base.Node;

public class GraphTestUtils {

    public static void printNodes(List<Node> nodes){
        System.out.print(" ");
        System.out.print(" ");
        System.out.print("Path__: ");
        for (Node node : nodes) {
            System.out.print(node.getLabel() + " ");
        }
    }
}
