package features;

import base.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Mst extends GraphFeatureComponent {


    public Mst(BaseGraph graph) {
        super(graph);
    }

    @Override
    public List<Node> depthSearch(Node node, Node curNode, Set<Node> passedNodes, List<Node> curPath) {
        throw new NotImplementedException();
    }

    @Override
    public BaseGraph findMst() {


        //Todo: Read:
        // https://web.eecs.umich.edu/~pettie/papers/jacm-optmsf.pdf
        // https://www.cs.princeton.edu/~chazelle/pubs/mst.pdf

            List<Edge> mstEdges = graph.getEdges();
//            List<Node> realRootNodes = (findAllRoots(graph).stream().filter(x -> (!x.getNeighbors().isEmpty()))).collect(Collectors.toList());
//
//            for (Node root : realRootNodes) {
//            }
//            for (Map.Entry<Node, Node> entry : graph.nodeConnections.entrySet()) {
//                Node target = entry.getValue();
//                Node source = entry.getKey();
//            }
//
//            int i = 0;
//            int Mc = 0;
//            int maxSize = 0;
//            List<Node> liveNodes = new ArrayList<>();
//            while ((!liveNodes.isEmpty()) && areAllNodesLife(liveNodes, liveNodes)) {
//                i++;
//                Node curNode = liveNodes.get(0);
//                Set<Node> someEdges = curNode.getNeighbors();
//
//                while (someEdges.size() < maxSize) {
//
//                }
//            }
        BaseGraph mst = new BaseGraph(graph.getNodes(), mstEdges);
            return mst;
        }

    private static boolean areAllNodesLife(List<Node> nodes, List<Node> lifeNodes) {
        for (Node node : nodes) {
            if (!lifeNodes.contains(node)) {
                return false;
            }
        }
        return true;
    }
}
