package features;

import base.BaseGraph;
import base.IGraph;
import base.Node;

import java.util.List;
import java.util.Set;

public class DepthSearchAndMst extends GraphFeatureComponent {


    public DepthSearchAndMst(BaseGraph graph) {
        super(graph);
    }
    

    @Override
    public List<Node> depthSearch(Node node) {
    	DepthSearch ds = new DepthSearch(this.getGraph());
        return ds.depthSearch(node);
    }

    @Override
    public List<Node>  findMst() {
    	Mst_DJP mst = new Mst_DJP(this.getGraph());
        return mst.findMst();
    }

}
