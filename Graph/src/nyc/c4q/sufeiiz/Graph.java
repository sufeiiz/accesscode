package nyc.c4q.sufeiiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sufeizhao on 11/15/15.
 */
public class Graph {
    List<Vertex> list = new ArrayList<Vertex>();

    public void addVertex(String name) {
        list.add(new Vertex(name));
    }

    public void addEdge(String from, String to, int weight) {
        if (getVertex(from) != null && getVertex(to) != null)
            getVertex(from).edgeTo(getVertex(to), weight);
    }

    public void getNeighbor(String name) {
        if (getVertex(name) != null) {
            HashMap<Vertex, Integer> map = getVertex(name).getEdgeWeights();
            for (Vertex vertex : map.keySet()) {
                System.out.print(vertex.name + " " + map.get(vertex) + ", ");
            }
            System.out.println();
        }
    }

    public Vertex getVertex(String name) {
        for (Vertex vertex : list) {
            if (vertex.name.equals(name))
                return vertex;
        }

        return null;
    }
}
