package base;

public class Edge {
    private Node target;
    private Node source;

    public Edge(Node target, Node source) {
        this.target = target;
        this.source = source;
    }

    public Node getTarget() {
        return target;
    }

    public void setTarget(Node target) {
        this.target = target;
    }

    public Node getSource() {
        return source;
    }

    public void setSource(Node source) {
        this.source = source;
    }

    public int getValue() {
        throw new NotImplementedException();
    }

    public void setValue(int value) {
        throw new NotImplementedException();
    }

}
