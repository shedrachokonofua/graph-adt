import graph.*;

class Test {
  public static void main(String[] args) {
    AdjacencyListGraph<Integer, String> graph = new AdjacencyListGraph<Integer, String>();
    
    Vertex<Integer> v1 = graph.insertVertex(1);
    Vertex<Integer> v2 = graph.insertVertex(2);
    Vertex<Integer> v3 = graph.insertVertex(3);
    Vertex<Integer> v4 = graph.insertVertex(4);
    Vertex<Integer> v5 = graph.insertVertex(5);

    graph.insertEdge(v1, v3);
    graph.insertEdge(v1, v2);
    graph.insertEdge(v3, v2);
    graph.insertEdge(v1, v4);
    graph.insertEdge(v4, v1);
    graph.insertEdge(v4, v5);

    // graph.dfs(v1);

    for(Edge<Integer, String> edge : graph.findPath(v3, v5)) {
      edge.log();
    }
  }
}