package features;

import java.util.List;
import java.util.Set;

import base.BaseGraph;
import base.Edge;
import base.Node;
import base.NotImplementedException;

public class Mst_DJP extends GraphFeatureComponent {


    public Mst_DJP(BaseGraph graph) {
        super(graph);
    }

    @Override
    public List<Node> depthSearch(Node node, Node curNode, Set<Node> passedNodes, List<Node> curPath) {
        throw new NotImplementedException();
    }

    @Override
    public BaseGraph findMst() {
    	List<Edge> mstEdges = graph.getEdges();
    	BaseGraph mst = new BaseGraph(graph.getNodes(), mstEdges);
    	//Todo: probably better to have this if i am not motivated enough to get the other one working ;)
		return mst;
    }

}
