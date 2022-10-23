package features;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

import base.BaseGraph;
import base.Node;
import base.NotImplementedException;

public class Mst_DJP extends GraphFeatureComponent {

    private static final Comparator<Map.Entry<UUID,Pair<UUID,Integer>>> comperator = Comparator.comparingInt(x->x.getValue().getRight());

    private final BaseGraph mst_graph;  
    
    public Mst_DJP(BaseGraph graph) {
        super(graph);
        //dont wonna risk to change the "original" graph
        this.mst_graph = new BaseGraph(graph);
    }

    @Override
    public List<Node> depthSearch(Node startNode, Node node) {
        throw new NotImplementedException();
    }

    @Override
    public List<WeightedNode> findMst() {
    	if (this.getMstGraph().getNodes().isEmpty()){
    		return new ArrayList<>();
    	}
    	//incompatible nodes arnt supported...
    	this.getMstGraph().getNodes().forEach(x->{if (!(x instanceof WeightedNode)) {throw new NotImplementedException();}});
    	WeightedNode curNode = (WeightedNode) this.getMstGraph().getNodes().get(0);
        List<WeightedNode> mst = new ArrayList<>();   
        Map<UUID, Pair<UUID, Integer>> possibleNextNodes = new HashMap<>();   
        curNode.getNeighbors().forEach((x,y)->possibleNextNodes.put(x.getId(), Pair.of(curNode.getId(),y)));
        
        return findMstHelper(curNode, possibleNextNodes, mst);  
    }
    
    private List<WeightedNode> findMstHelper(WeightedNode curNode , Map<UUID, Pair<UUID, Integer>> possibleNextNodes, List<WeightedNode> mst){
        mst.add(curNode);
        Set<? extends Node> newNodes = curNode.getNeighbors().keySet().stream().filter(x->!mst.contains(x)).collect(Collectors.toCollection(HashSet::new));
        for (Node newNode : newNodes) {
            if (possibleNextNodes.containsKey(newNode.getId()) && 
            		possibleNextNodes.get(newNode.getId()).getValue() > curNode.getNeighbors().get(newNode)) {
                possibleNextNodes.put(newNode.getId(), Pair.of( curNode.getId(),curNode.getNeighbors().get(newNode)));
            }
            possibleNextNodes.putIfAbsent(newNode.getId(), Pair.of( curNode.getId(),curNode.getNeighbors().get(newNode)));
        }
        //subgraph is complete -> new subgraph is entered
        if (possibleNextNodes.isEmpty()){
        	WeightedNode lastSeenNode = mst.get(mst.size()-1);
        	Map<Node, Integer> updatedNeighbors = lastSeenNode.getNeighbors().entrySet().stream().filter(e->e.getKey().getNeighbors().containsKey(lastSeenNode))
        	.collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
        	lastSeenNode.setNeighbors(updatedNeighbors);
            return findMstSubGraphsHelper(mst); 
        }
        
        Entry<UUID, Pair<UUID, Integer>> entry = possibleNextNodes.entrySet().stream().min(comperator).get();
        Pair<WeightedNode, Pair<UUID, Integer>> nextNode = Pair.of((WeightedNode) this.getMstGraph().getNodeById(entry.getKey()),entry.getValue());
        
        WeightedNode pastNode = mst.get(mst.size()-1);
        updateNeighborhood(nextNode, pastNode, mst);
        possibleNextNodes.remove(nextNode.getKey().getId());
        return findMstHelper(nextNode.getKey(), possibleNextNodes, mst );
    }
    
    //unconnected subgraph problematic
    private List<WeightedNode> findMstSubGraphsHelper(List<WeightedNode> mst){
    	List<? extends Node> unseenNodes = this.getMstGraph().getNodes().stream().filter
    			  (x->!mst.contains(x)).collect(Collectors.toCollection(ArrayList::new));
    	if (!unseenNodes.isEmpty()) {
    		Map<UUID, Pair<UUID, Integer>> possibleNextNodes = new HashMap<>();
    		unseenNodes.get(0).getNeighbors().forEach((x,y)->possibleNextNodes.put(x.getId(),Pair.of(unseenNodes.get(0).getId(), y)));
            return findMstHelper((WeightedNode)unseenNodes.get(0), possibleNextNodes, mst);
    	}
    	return mst;
    }
 
    private void updateNeighborhood(Pair<WeightedNode, Pair<UUID, Integer>> nextNode, WeightedNode pastNode, List<WeightedNode> mst ) {
        Map<Node, Integer> pastNodeNeighbors = pastNode.getNeighbors().entrySet().stream().filter(x->mst.contains(x.getKey()) 
        		&& x.getKey().getNeighbors().containsKey(pastNode))
     		   .collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
        pastNode.setNeighbors(pastNodeNeighbors);
        this.getMstGraph().getNodeById(nextNode.getValue().getKey()).addNeighbor(nextNode.getKey(), nextNode.getValue().getValue());
    }
    
    public BaseGraph getMstGraph() {
        return this.mst_graph;
    }
    
}
