package features;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

import base.Node;

public class LabeledWeightedNode extends LabeledNode{

	public LabeledWeightedNode(String label, Map<Node,Integer> neighbors) {
		super(label, neighbors);
	}
	

}
