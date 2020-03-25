package graph.edge;

import graph.utils.Pair;
import graph.vertex.Vertex;

public class Edge<T> {
  Vertex<T> u;
  Vertex<T> v;

  public Edge (Vertex<T> u, Vertex<T> v) {
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

  public boolean equals (Edge<T> edge) {
    return (
      edge.getEndPoints().includes(this.getU()) &&
      edge.getEndPoints().includes(this.getV())
    );
  };
};