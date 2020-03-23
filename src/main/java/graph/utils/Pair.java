package graph.utils;

public class Pair<T, U> {
  T t;
  U u;

  public Pair(T a, U b) {
    this.t = a;
    this.u = b;
  }

  public boolean includes(Object a) {
    return this.t == (T) a || this.u == (U) a;
  }

}