import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import base.BaseGraph;
import base.IGraph;
import base.Node;
import features.LabeledWeightedNode;
import features.Mst_DJP;

public class MstTest {

	public static final List<Node> nodes = new ArrayList<>();
	
	@BeforeAll
	static void beforeAll() {
	    Node a = new LabeledWeightedNode("A", new HashMap<>()); // a-b
	    Node b = new LabeledWeightedNode("B", new HashMap<>()); // b-c
	    Node c = new LabeledWeightedNode("C", new HashMap<>()); // c-d,e
	    Node d = new LabeledWeightedNode("D", new HashMap<>()); // d
	    Node e = new LabeledWeightedNode("E", new HashMap<>()); // e-f
	    Node f = new LabeledWeightedNode("F", new HashMap<>());

	    a.setNeighbors(Map.of( b,2));
	    b.setNeighbors(Map.of( a,2, c, 2));
	    c.setNeighbors(Map.of( b,2, d,2,e,2));
	    d.setNeighbors(Map.of( c,2));
	    e.setNeighbors(Map.of( c,2, f,2));
	    f.setNeighbors(Map.of( e,2));
	    
	    nodes.add(a);
	    nodes.add(b);
	    nodes.add(c);
	    nodes.add(d);
	    nodes.add(e);
	    nodes.add(f);
	}
	
    @Test
    public void MstDJP_when_NormalGraphIsGiven(){
        IGraph graph = new Mst_DJP(new BaseGraph (nodes));
        List<Node> mst = graph.findMst();
        GraphTestUtils.printNodes(mst);
        Assertions.assertTrue(mst.size()==nodes.size());
        //Assertions.assertTrue(mst.containsAll(nodes));
    }
}
