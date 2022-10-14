package features;

import base.Node;

public class LabeledNode extends Node {

    private String label;

    public LabeledNode(String label) {
        super();
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
}
