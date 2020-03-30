package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AdjacencyListGraph<T, E> extends Graph<T, E> {
  private HashMap<Vertex<T>, ArrayList<Edge<T, E>>> adjacencyList;

  public AdjacencyListGraph() {
    this.adjacencyList = new HashMap<Vertex<T>, ArrayList<Edge<T, E>>>();
  }

  @Override
  public Vertex<T> insertVertex (T element) {
    Vertex<T> vertex = new Vertex<T>(element);
    this.adjacencyList.putIfAbsent(vertex, new ArrayList<Edge<T, E>>());
    
    return vertex;
  }

  @Override
  public Vertex<T> insertVertex(Vertex<T> vertex) {
    return this.insertVertex(vertex.getValue());
  }

  @Override
  public void removeVertex(Vertex<T> vertex) {
    // TODO
  }

  @Override
  public Integer numVertices() {
    return this.adjacencyList.size();
  }

  @Override
  public Integer numEdges() {
    // TODO
    return null;
  }

  @Override
  public Iterable<Vertex<T>> getVertices() {
    return this.adjacencyList.keySet();
  }

  @Override
  public Iterable<Edge<T, E>> getEdges() {
    // TODO
    return null;
  }

  @Override
  public Edge<T, E> getEdge(Vertex<T> u, Vertex<T> v) {
    List<Edge<T, E>> originVertexAdjacentList = this.adjacencyList.get(u);
    
    if (originVertexAdjacentList == null) return null;
  
    Edge<T, E> result = null;
    Edge<T, E> query = new Edge<T, E>(u, v);

    for (Edge<T, E> incidentEdge : originVertexAdjacentList) {
      if (incidentEdge.equals(query)) {
        result = incidentEdge;
        break;
      }
    }
    return result;
  }

  @Override
  public Edge<T, E> getEdge(Edge<T, E> edge) {
    return this.getEdge(edge.getU(), edge.getV());
  }

  @Override
  public void insertEdge(Vertex<T> u, Vertex<T> v) {
    if (this.getEdge(u, v) != null) return;

    Vertex<T> origin = this.insertVertex(u);
    Edge<T, E> edge = new Edge<T, E>(origin, v);
    this.adjacencyList.get(origin).add(edge);
  }

  @Override
  public void insertEdge(Vertex<T> u, Vertex<T> v, E element) {
    if (this.getEdge(u, v) != null) return;

    Vertex<T> origin = this.insertVertex(u);
    Edge<T, E> edge = new Edge<T, E>(element, origin, v);
    this.adjacencyList.get(origin).add(edge);
  }

  @Override
  public void insertEdge(Edge<T, E> edge) {
    if (this.getEdge(edge) != null) return;

    Vertex<T> origin = this.insertVertex(edge.getU());
    this.adjacencyList.get(origin).add(edge);
  }

  @Override
  public void removeEdge(Edge<T, E> edge) {
  }

  @Override
  public Iterable<Edge<T, E>> getOutgoingEdges(Vertex<T> vertex) {
    List<Edge<T, E>> outgoingEdges = this.adjacencyList.get(vertex);
    return outgoingEdges;
  }

  @Override
  public Iterable<Edge<T, E>> getIncomingEdges(Vertex<T> vertex) {
    // TODO
    return null;
  }

  @Override
  public boolean hasVertex(Vertex<T> vertex) {
    return this.adjacencyList.containsKey(vertex);
  }

}
