package graph.vertex;

public class Vertex<T> {
  private T value;

  public Vertex(T value) {
    this.value = value;
  }

  public T getValue() {
    return this.value;
  }

  @Override
  public boolean equals (Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || o.getClass() != this.getClass()) {
      System.out.println(o.getClass());
      return false;
    }

    Vertex<T> vertex = (Vertex<T>) o;
    return vertex.getValue().equals(this.getValue());
  };
}
