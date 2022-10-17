package base;

import java.util.*;

public class Node {
	

	protected Map<Node,Integer> neighbors;
    private final UUID id;

    
    public Node(Set<Node> nodes) {
        nodes.forEach(x->this.neighbors.put(x,1));
        this.id = UUID.randomUUID();
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
        this.neighbors.put(neighbor,1);
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
