package graph.edge;
import graph.vertex.*;
import graph.utils.*;

public abstract class Edge<T> {
  public abstract Pair<Vertex<T>, Vertex<T>> getEndPoints();
  public abstract Vertex<T> getU();
  public abstract Vertex<T> getV();

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
      edge.getEndPoints().includes(this.getU()) ||
      edge.getEndPoints().includes(this.getV())
    );
  };
};