package features;

import base.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DepthSearch extends GraphFeatureComponent {

    public DepthSearch(BaseGraph graph) {
        super(graph);
    }

    @Override
    public List<Node> depthSearch(Node node, Node curNode, Set<Node> passedNodes, List<Node> curPath)  {
            passedNodes.add(curNode);
            curPath.add(curNode);
            if (curNode.getNeighbors().contains(node)) {
                curPath.add(node);
                return curPath;
            }
            Node nextNode = curNode;
            Set<Node> curNeighbors = curNode.getNeighbors();
            while (curNeighbors.isEmpty() || passedNodes.containsAll(curNeighbors)) {
                nextNode = curPath.remove(curPath.size() - 1);
                curNeighbors = nextNode.getNeighbors();
            }
            if (!curPath.contains(nextNode)) curPath.add(nextNode);
            nextNode = curNeighbors.stream().filter(x -> !passedNodes.contains(x)).collect(Collectors.toList()).get(0);
            return depthSearch(node, nextNode, passedNodes, curPath);
    }

    @Override
    public BaseGraph findMst() {
        throw new NotImplementedException();
    }

}
