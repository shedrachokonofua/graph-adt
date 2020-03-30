package utils;

public class Pair<T, U> {
  private T t;
  private U u;

  public Pair(T a, U b) {
    this.t = a;
    this.u = b;
  }

  public T getLeft() {
    return this.t;
  }

  public U getRight() {
    return this.u;
  }

  public boolean includes(Object a) {
    return this.getLeft() == (T) a || this.getRight() == (U) a;
  }

}