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
    public List<Node> depthSearch(Node node) {
        throw new NotImplementedException();
    }

    @Override
    public  List<Node> findMst() {

        //ToDo: Read and Code
	// https://web.eecs.umich.edu/~pettie/papers/jacm-optmsf.pdf
	// https://www.cs.princeton.edu/~chazelle/pubs/mst.pdf
            return new ArrayList<>();
        }
}
