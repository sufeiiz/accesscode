package nyc.c4q.sufeiiz;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sufeizhao on 11/15/15.
 */
public class Vertex {
    String name;
    HashMap<Vertex, Integer> edgeWeights = new HashMap<Vertex, Integer>();

    public Vertex(String name) {
        this.name = name;
    }

    public void edgeTo(Vertex to, int weight) {
        edgeWeights.put(to, weight);
    }

    public HashMap<Vertex, Integer> getEdgeWeights() {
        return edgeWeights;
    }
}
