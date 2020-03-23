package graph.edge;
import graph.vertex.*;
import graph.utils.*;

public class UndirectedEdge<T> extends Edge<T> {
  Vertex<T> u;
  Vertex<T> v;

  public UndirectedEdge (Vertex<T> u, Vertex<T> v) {
    this.u = u;
    this.v = v;
  }

  public Pair<Vertex<T>, Vertex<T>> getEndPoints () {
    return new Pair<Vertex<T>,Vertex<T>>(this.u, this.v);
  }

  public Vertex<T> getU () {
    return this.u;
  };

  public Vertex<T> getV () {
    return this.v;
  };

  @Override
  public boolean equals (Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || !(o instanceof Edge)) {
      return false;
    }
    
    Edge<T> edge = (Edge<T>) o;

    return (
      this.getU() == edge.getU() &&
      this.getV() == edge.getV()
    );
  };
}
