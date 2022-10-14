package base;

import java.util.*;

public class Node {
    private UUID nodeId;
    private Set<Node> neighbors = new HashSet<>();

    public Node() {
        this.nodeId = UUID.randomUUID();
    }

    public void initConnectionsList(List<Edge> someEdges) {
        for (Edge edge : someEdges) {
            if (Objects.equals(edge.getSource().getNodeId(), this.nodeId)) {
                this.neighbors.add(edge.getTarget());
            }
            if (Objects.equals(edge.getTarget().getNodeId(), this.nodeId)) {
                this.neighbors.add(edge.getSource());
            }
        }
    }

    public String getLabel() {
        throw new NotImplementedException();
    }

    public void setLabel(String label) {
        throw new NotImplementedException();
    }

    public UUID getNodeId() {
        return nodeId;
    }

    public void setNodeId(UUID nodeId) {
        this.nodeId = nodeId;
    }

    public Set<Node> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Set<Node> neighbors) {
        this.neighbors = neighbors;
    }
}
