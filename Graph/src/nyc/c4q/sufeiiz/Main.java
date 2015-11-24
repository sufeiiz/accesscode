package nyc.c4q.sufeiiz;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("V1");
        graph.addVertex("V2");
        graph.addVertex("V3");
        graph.addVertex("V4");
        graph.addVertex("V5");
        graph.addVertex("V6");
        graph.addVertex("V7");

        graph.addEdge("V1", "V2", 2);
        graph.addEdge("V1", "V4", 1);
        graph.addEdge("V2", "V4", 3);
        graph.addEdge("V2", "V5", 10);
        graph.addEdge("V3", "V1", 4);
        graph.addEdge("V3", "V6", 5);
        graph.addEdge("V4", "V3", 2);
        graph.addEdge("V4", "V5", 2);
        graph.addEdge("V4", "V6", 8);
        graph.addEdge("V4", "V7", 4);
        graph.addEdge("V5", "V7", 6);
        graph.addEdge("V7", "V6", 1);

        graph.getNeighbor("V1");
        graph.getNeighbor("V2");
        graph.getNeighbor("V3");
        graph.getNeighbor("V4");
        graph.getNeighbor("V5");
        graph.getNeighbor("V6");
        graph.getNeighbor("V7");
    }
}
