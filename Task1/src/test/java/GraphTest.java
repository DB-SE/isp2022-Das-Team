import base.*;
import features.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class GraphTest {

public static final List<Node> nodes = new ArrayList<>();

    @Test
    public void throwException_when_featureImplementationIsMissing(){
        BaseGraph graph = new BaseGraph (nodes);
        IGraph graph_mst = new Mst(graph);
        IGraph graph_deep = new DepthSearch(graph);
        Node node = new Node(new HashSet<>());
        Assertions.assertThrows(NotImplementedException.class, ()-> node.addNeighbor(node, 2));
        Assertions.assertThrows(NotImplementedException.class, ()-> node.getLabel());
        Assertions.assertThrows(NotImplementedException.class, ()-> graph.findMst());
        Assertions.assertThrows(NotImplementedException.class, ()-> graph.depthSearch(null));
        Assertions.assertThrows(NotImplementedException.class, ()-> graph_mst.depthSearch(null));
        Assertions.assertThrows(NotImplementedException.class, ()-> graph_deep.findMst());
    }
    

}