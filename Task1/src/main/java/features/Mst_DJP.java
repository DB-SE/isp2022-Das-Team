package features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import base.BaseGraph;
import base.Node;
import base.NotImplementedException;

public class Mst_DJP extends GraphFeatureComponent {


    private static final Comparator<Map.Entry<Node,Integer>> comperator = Comparator.comparingInt(Map.Entry::getValue);
    
    public Mst_DJP(BaseGraph graph) {
        super(graph);
    }

    @Override
    public List<Node> depthSearch(Node node) {
        throw new NotImplementedException();
    }

    @Override
    public List<Node> findMst() {
        Node curNode = this.getGraph().getNodes().get(0);
        return helper(curNode, new HashMap<>(curNode.getNeighbors()), new ArrayList<>());
    }
    
    private List<Node> helper(Node curNode , Map<Node, Integer>possibleNextNodes, List<Node> mst){
        mst.add(curNode);
        Set<Node> newNodes = curNode.getNeighbors().keySet().stream().filter(x->!mst.contains(x)).collect(Collectors.toCollection(HashSet::new));
        for (Node newNode : newNodes) {
            if (possibleNextNodes.containsKey(newNode) && possibleNextNodes.get(newNode) > curNode.getNeighbors().get(newNode)) {
                possibleNextNodes.put(newNode, curNode.getNeighbors().get(newNode));
            }
            possibleNextNodes.putIfAbsent(newNode, curNode.getNeighbors().get(newNode));
        }
        if (possibleNextNodes.isEmpty()){
            return mst;
        }
        Node nextNode = possibleNextNodes.entrySet().stream().min(comperator).get().getKey();
        possibleNextNodes.remove(nextNode);
        return helper(nextNode, possibleNextNodes, mst );
    }
    
}
