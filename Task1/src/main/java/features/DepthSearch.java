package features;

import base.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DepthSearch extends GraphFeatureComponent {

    public DepthSearch(BaseGraph graph) {
        super(graph);
    }

    
    public List<Node> depthSearch(Node toBeFound) {
        if (this.getGraph().getNodes().isEmpty() || !(this.getGraph().getNodes().contains(toBeFound))) {
            return new ArrayList<>();
        }
        Node curNode = this.getGraph().getNodes().get(0);
        return helper(curNode,toBeFound,new ArrayList<>(), new HashSet<>(),new ArrayList<>());
    }


    private List<Node> helper(Node curNode, Node toBeFound, List<Node>possibleNextNodes, Set<Node> passedNodes, List<Node> curPath){
        curPath.add(curNode);
        passedNodes.add(curNode);
        Set<Node> curNeighbors = curNode.getNeighbors().keySet();
        possibleNextNodes.addAll(curNeighbors.stream().filter(x->(!(passedNodes.contains(x)) && !(possibleNextNodes.contains(x)))).collect(Collectors.toSet()));
        //Node is already reachable
        if (possibleNextNodes.contains(toBeFound)){
            curPath.add(toBeFound);
            return curPath;
        }
        // Node isnt reachable from start
        if (possibleNextNodes.isEmpty()){
            return new ArrayList<>();
        }
        curNode = possibleNextNodes.remove(possibleNextNodes.size()-1);
        if (curNeighbors.isEmpty() || passedNodes.containsAll(curNeighbors)) {
            for (Node node : curPath) {
                if (node.getNeighbors().containsKey(curNode)) {
                    curPath = curPath.subList(0, curPath.indexOf(node));
                }
            }
        }
        return helper(curNode, toBeFound,possibleNextNodes,passedNodes, curPath);
    }
          
       
    @Override
    public List<Node>  findMst() {
        throw new NotImplementedException();
    }

}
