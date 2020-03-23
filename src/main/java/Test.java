import graph.vertex.Vertex;

class Test {
  public static void main(String[] args) {
    Vertex<Integer> u = new Vertex<Integer>(1);
    Vertex<Integer> v = new Vertex<Integer>(2);
    Vertex<Integer> w = new Vertex<Integer>(2);

    System.out.println(u == v);
    System.out.println(w.equals(v));

    // Vertex<Integer> u = new Vertex(1);(1);
    // UndirectedEdge e = new UndirectedEdge<Integer, Integer>(Vertex(), v)
  }
}