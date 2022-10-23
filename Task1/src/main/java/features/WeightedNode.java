package features;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import base.Node;
import base.NotImplementedException;

public class WeightedNode extends Node {

public WeightedNode(Map<Node,Integer> neighbors) {
	   super(neighbors);
	}

	@Override
	public void addNeighbor(Node neighbor, Integer value) {
		Map<Node,Integer> newNeighbors = new HashMap<>(this.neighbors);
		newNeighbors.put(neighbor,value);
		this.setNeighbors(newNeighbors);
	}
	
	@Override
    public void setNeighbors(Map<Node,Integer> neighbors) {
    	this.neighbors = neighbors;
    }
	
	public void updateWeight(Node node, int newWeight) {
		this.neighbors.put(node, newWeight);
	}
	
}

