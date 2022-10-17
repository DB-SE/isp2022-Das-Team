package features;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

import base.Node;
import base.NotImplementedException;

public class LabeledNode extends Node {

    private String label;

    public LabeledNode(String label, Set<Node> nodes) {
        super(nodes);
        this.label = label;
    }
    
    protected LabeledNode(String label, Map<Node,Integer> neighbors) {
        super(neighbors);
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }
    
    @Override
    public void setNeighbors(Map<Node,Integer> neighbors) {
    	this.neighbors = neighbors;
    }
    
    @Override
    public void addNeighbor(Node neighbor, Integer value) {
    	this.neighbors.put(neighbor, value) ;
    }
}
