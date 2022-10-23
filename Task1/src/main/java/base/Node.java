package base;

import java.util.*;

public class Node {

	protected Map<Node,Integer> neighbors;
    private final UUID id;
    protected String label;
    
    public Node(Set<Node> nodes) {
        nodes.forEach(x->this.neighbors.put(x,1));
        this.id = UUID.randomUUID();
    }
    
    public Node() {
    	this.neighbors = new HashMap<>(); 
        this.id = UUID.randomUUID();
    }
    
    public Node(Node node) {
    	this.neighbors = new HashMap<>(); 
        this.id = node.getId();
    }
    
    protected Node(Map<Node,Integer> neighbors) {
    	this.neighbors = neighbors;
        this.id = UUID.randomUUID();
    }

    public Map<Node,Integer> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Map<Node,Integer> neighbors) {
        throw new NotImplementedException();
    }
    
    public void setNeighbors(Set<Node> neighbors) {
    	neighbors.forEach(x->this.neighbors.put(x,1));
    }

    public void addNeighbor(Node neighbor) {
    	Map<Node,Integer> newNeighbors = new HashMap<>(this.neighbors);
    	newNeighbors.put(neighbor,1);
    	this.setNeighbors(newNeighbors);
    }
    
    public void addNeighbor(Node neighbor, Integer value) {
        throw new NotImplementedException();
    }

    public UUID getId() {
        return id;
    }
   
    public String getLabel() {
        throw new NotImplementedException();
    }

    public void setLabel(String label) {
        throw new NotImplementedException();
    }

}
