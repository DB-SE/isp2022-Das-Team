import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import base.BaseGraph;
import base.IGraph;
import base.Node;
import base.NotImplementedException;
import features.LabeledWeightedNode;
import features.Mst_DJP;
import features.WeightedNode;

public class MstTest {

	public static final List<Node> nodes_normal = new ArrayList<>();
	public static final List<Node> nodes_unconnected = new ArrayList<>();
	public static final List<Node> nodes = new ArrayList<>();
	
	@BeforeAll
	static void beforeAll() {
	    Node a = new LabeledWeightedNode("A", new HashMap<>()); // a-b
	    Node b = new LabeledWeightedNode("B", new HashMap<>()); // b-c-f
	    Node c = new LabeledWeightedNode("C", new HashMap<>()); // c-d,e
	    Node d = new LabeledWeightedNode("D", new HashMap<>()); // d
	    Node e = new LabeledWeightedNode("E", new HashMap<>()); // e-f
	    Node f = new LabeledWeightedNode("F", new HashMap<>());
	    Node g = new LabeledWeightedNode("G", new HashMap<>()); // Node in isolated subgraph
	    Node h = new LabeledWeightedNode("H", new HashMap<>()); // Node in isolated subgraph
	    Node i = new LabeledWeightedNode("I", new HashMap<>()); // isolated Node

	    a.setNeighbors(Map.of( b,2));
	    b.setNeighbors(Map.of( a,2, c, 2, f,3));
	    c.setNeighbors(Map.of( b,2, d,2,e,2));
	    d.setNeighbors(Map.of( c,2));
	    e.setNeighbors(Map.of( c,2, f,1));
	    f.setNeighbors(Map.of( e,1,b,3));
	    g.setNeighbors(Map.of( h,2));
	    h.setNeighbors(Map.of( g,2));
	    
	    nodes_normal.addAll(List.of( a,b,c,d,e,f));
	    nodes_unconnected.addAll(List.of( a,b,c,d,e,f,g,h,i));
		nodes.add(new Node(new HashSet<>()));
		nodes.addAll(nodes_normal);
	}
	
    @Test
    public void MstDJP_when_NormalGraphIsGiven(){
        IGraph graph = new Mst_DJP(new BaseGraph(nodes_normal));
        List<WeightedNode> mst = new ArrayList<>();
        mst = graph.findMst();
        GraphTestUtils.printNodes(mst);
        int sum = GraphTestUtils.sumWeightsOfMst(mst);
        Assertions.assertTrue(mst.size()==nodes_normal.size());
        Assertions.assertTrue(sum == 9);
    }
    
    @Test
    public void MstDJP_when_UnconnectedGraphIsGiven(){
        IGraph graph = new Mst_DJP(new BaseGraph(nodes_unconnected));
        List<WeightedNode> mst = new ArrayList<>();
        mst = graph.findMst();
        GraphTestUtils.printNodes(mst);
        int sum = GraphTestUtils.sumWeightsOfMst(mst);
        Assertions.assertTrue(mst.size()==nodes_unconnected.size());
        Assertions.assertTrue(sum == 11);
    }
    
    @Test
    public void throwException_when_GraphWithUnWeightedNodesIsGiven(){
        IGraph graph = new Mst_DJP(new BaseGraph(nodes));
        Assertions.assertThrows(NotImplementedException.class, ()-> graph.findMst());
    }
    
}
