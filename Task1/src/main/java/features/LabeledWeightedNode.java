package features;

import java.util.Map;

import base.Node;

public class LabeledWeightedNode extends WeightedNode implements ILabeled{

	public LabeledWeightedNode(String label, Map<Node,Integer> neighbors) {
		super(neighbors);
		this.setLabel(label);
	}
		
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
}
