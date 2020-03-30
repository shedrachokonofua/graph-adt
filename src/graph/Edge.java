package graph;

import utils.Pair;

public class Edge<T, E> {
  private Vertex<T> u;
  private Vertex<T> v;
  private E element;

  public Edge (Vertex<T> u, Vertex<T> v) {
    this.u = u;
    this.v = v;
  };

  public Edge (E element, Vertex<T> u, Vertex<T> v) {
    this.u = u;
    this.v = v;
    this.element = element;
  };

  public Pair<Vertex<T>, Vertex<T>> getEndPoints () {
    return new Pair<Vertex<T>,Vertex<T>>(this.u, this.v);
  };

  public Vertex<T> getU () {
    return this.u;
  };

  public Vertex<T> getV () {
    return this.v;
  };

  public Vertex<T> getOpposite (Vertex<T> vertex) {
    if (this.getU().equals(vertex)) return this.getV();
    if (this.getV().equals(vertex)) return this.getU();
    return null;
  }

  public void setElement(E element) {
    this.element = element;
  };

  public E getElement() {
    return this.element;
  };

  public void log() {
    System.out.print(" >> ");
    this.getU().log();
    System.out.print(" -> ");
    this.getV().log();
    System.out.println();
  }

  @Override
  public boolean equals (Object o) {
    if (o == this) return true;
    
    if (!(o instanceof Edge)) {
      return false;
    }

    Edge<T, E> edge = (Edge<T, E>) o;

    return (
      edge.getEndPoints().includes(this.getU()) &&
      edge.getEndPoints().includes(this.getV())
    );
  };

  @Override
  public int hashCode () {
    return this.getElement().hashCode();
  }
};