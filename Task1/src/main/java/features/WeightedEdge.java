package features;


import base.Edge;
import base.Node;


public class WeightedEdge extends Edge {

    private int value;

    public WeightedEdge(int value, Node target, Node source) {
        super(target, source);
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

}
