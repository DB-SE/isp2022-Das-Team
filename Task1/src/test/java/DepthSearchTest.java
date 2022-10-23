import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import base.BaseGraph;
import base.IGraph;
import base.Node;
import features.DepthSearch;
import features.LabeledWeightedNode;

public class DepthSearchTest {

	public static final List<Node> nodes = new ArrayList<>();
	
	@BeforeAll
	static void beforeAll() {
	    Node a = new LabeledWeightedNode("A", new HashMap<>()); // a-b
	    Node b = new LabeledWeightedNode("B", new HashMap<>()); // b-c
	    Node c = new LabeledWeightedNode("C", new HashMap<>()); // c-d,e
	    Node d = new LabeledWeightedNode("D", new HashMap<>()); // d
	    Node e = new LabeledWeightedNode("E", new HashMap<>()); // e-f
	    Node f = new LabeledWeightedNode("F", new HashMap<>());
	    Node g = new LabeledWeightedNode("G", new HashMap<>()); // Node in isolated subgraph
	    Node h = new LabeledWeightedNode("H", new HashMap<>()); // Node in isolated subgraph
	    Node i = new LabeledWeightedNode("I", new HashMap<>()); // isolated Node

	    a.setNeighbors(Map.of( b,2));
	    b.setNeighbors(Map.of( a,2, c, 2));
	    c.setNeighbors(Map.of( b,2, d,2,e,2));
	    d.setNeighbors(Map.of( c,2));
	    e.setNeighbors(Map.of( c,2, f,2));
	    f.setNeighbors(Map.of( e,2));
	    g.setNeighbors(Map.of( h,2));
	    h.setNeighbors(Map.of( g,2));
	    
	    nodes.addAll(List.of( a,b,c,d,e,f,g,h,i));
	}
	
    @Test
    public void depthSearch_when_toBeFoundIsInUnConnectedGraph(){
        IGraph graph = new DepthSearch(new BaseGraph (nodes));
        Node toBeFound = nodes.get(7);
        Node start = nodes.get(6);
        GraphTestUtils.printNodes(nodes);
        List<Node> expectedResult = List.of(nodes.get(6),nodes.get(7));
        List<Node> path = graph.depthSearch(start, toBeFound);
        GraphTestUtils.printNodes(path);
        Assertions.assertEquals(expectedResult, path);
    }  
    
    @Test
    public void depthSearch_when_normalGraphIsGiven(){
        IGraph graph = new DepthSearch(new BaseGraph (nodes));
        Node toBeFound = nodes.get(5);
        Node start = nodes.get(0);
        GraphTestUtils.printNodes(nodes);
        List<Node> path = graph.depthSearch(start, toBeFound);
        List<Node> expectedResult = List.of(nodes.get(0),nodes.get(1),nodes.get(2),nodes.get(4),nodes.get(5));
        GraphTestUtils.printNodes(path);
        Assertions.assertEquals(expectedResult, path);
    }
	      
    @Test
    public void returnsEmptyList_when_toBeFoundIsInUnConnectedGraph(){
    	IGraph graph = new DepthSearch(new BaseGraph (nodes));
    	Node toBeFound = nodes.get(8);
    	Node start = nodes.get(0);
    	List<Node> path = graph.depthSearch(start, toBeFound);
    	Assertions.assertEquals(new ArrayList<>(), path);
    }
    
}
