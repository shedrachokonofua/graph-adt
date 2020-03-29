package graph;

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
    if (o == this) return true;
    
    if (!(o instanceof Vertex)) {
      return false;
    }

    Vertex<T> vertex = (Vertex<T>) o;
    return vertex.getValue().equals(this.getValue());
  };
  
  @Override
  public int hashCode () {
    return this.getValue().hashCode();
  }

  public void log () {
    System.out.print(this.value);
  }
}
