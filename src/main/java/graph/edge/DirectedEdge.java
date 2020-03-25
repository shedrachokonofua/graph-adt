package graph.edge;
import graph.vertex.Vertex;

public class DirectedEdge<T> extends Edge<T> {
  public DirectedEdge(Vertex<T> u, Vertex<T> v) {
    super(u, v);
  }

  public boolean equals (Edge<T> edge) {
    return (
      this.getU().equals(edge.getU()) &&
      this.getV().equals(edge.getV())
    );
  }
}
