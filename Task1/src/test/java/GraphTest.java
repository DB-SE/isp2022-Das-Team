import base.*;
import features.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class GraphTest {


    static List<Node> nodes = new ArrayList<>();
    static  {
        nodes.add(new LabeledNode("A"));
        nodes.add(new LabeledNode("B"));
        nodes.add(new LabeledNode("C"));
        nodes.add(new LabeledNode("D"));
        nodes.add(new LabeledNode("E"));
        nodes.add(new LabeledNode("F"));
        nodes.add(new LabeledNode("G"));
        nodes.add(new LabeledNode("H"));
    }

    static List<Edge> edges  = new ArrayList<>();
    static {
        edges.add(new WeightedEdge(1, nodes.get(0),nodes.get(1) )); // A->B
        edges.add(new WeightedEdge(1, nodes.get(1),nodes.get(2) )); // B->C
        edges.add(new WeightedEdge(1, nodes.get(2),nodes.get(3) )); // C->D
        edges.add(new WeightedEdge(1, nodes.get(2),nodes.get(4) )); // C->E
        edges.add(new WeightedEdge(1, nodes.get(3),nodes.get(6) )); // D->G
        edges.add(new WeightedEdge(1, nodes.get(3),nodes.get(5) )); // D->F
        edges.add(new WeightedEdge(1, nodes.get(5),nodes.get(7) )); // F->H
    }

    @Test
    public void depthSearch_when_normalGraphIsGiven(){
        IGraph graph = new DepthSearch(new BaseGraph (nodes,edges));
        Node toBeFound = nodes.get(7);
        Node root = nodes.get(0);
        List<Node> path = graph.depthSearch(toBeFound, root, new HashSet<>(), new ArrayList<>());
        List<Node> expectedResult = List.of(nodes.get(0),nodes.get(1),nodes.get(2),nodes.get(3),nodes.get(5),nodes.get(7));
        Assertions.assertEquals(expectedResult, path);
    }

    @Test
    public void mst_when_normalGraphIsGiven(){
        IGraph graph = new Mst(new BaseGraph (nodes,edges));
        BaseGraph mst = graph.findMst();
        Assertions.assertTrue(mst.getNodes().containsAll(nodes));
    }

    @Test
    public void throwException_when_featureImplementationIsMissing(){
        BaseGraph graph = new BaseGraph (nodes,edges);
        IGraph graph_mst = new Mst(graph);
        IGraph graph_deep = new DepthSearch(graph);
        Assertions.assertThrows(NotImplementedException.class, ()-> graph.findMst());
        Assertions.assertThrows(NotImplementedException.class, ()-> graph.depthSearch(null,null,new HashSet<>(),new ArrayList<>()));
        Assertions.assertThrows(NotImplementedException.class, ()-> graph_mst.depthSearch(null,null,new HashSet<>(),new ArrayList<>()));
        Assertions.assertThrows(NotImplementedException.class, ()-> graph_deep.findMst());

    }

}