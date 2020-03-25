package graph.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import graph.edge.DirectedEdge;
import graph.edge.Edge;
import graph.vertex.Vertex;

public class AdjacencyListGraph<T> implements Graph<T> {
  private Map<Vertex<T>, ArrayList<Vertex<T>>> adjacencyList;

  public AdjacencyListGraph() {

  }

  public void insertVertex(Vertex<T> vertex) {
    this.adjacencyList.putIfAbsent(vertex, new ArrayList<Vertex<T>>());
  }

  public void removeVertex(Vertex<T> vertex) {
    this.adjacencyList.values().stream().forEach(list -> list.remove(vertex));
  }

  public void insertEdge(Edge<T> edge) {
    this.adjacencyList.get(edge.getU()).add(edge.getV());
    this.adjacencyList.get(edge.getV()).add(edge.getU());
  }

  public void insertEdge(DirectedEdge<T> edge) {
    this.adjacencyList.get(edge.getU()).add(edge.getV());
  }

  public Edge<T> hasEdge(Vertex<T> u, Vertex<T> v) {
    // TODO Auto-generated method stub
  }

  public Iterator<Edge<T>> getEdges() {
    // TODO Auto-generated method stub
    return null;
  }

  public Iterator<Vertex<T>> getVertices() {
    // TODO Auto-generated method stub
    return null;
  }

  public Iterator<Edge<T>> incomingEdges() {
    // TODO Auto-generated method stub
    return null;
  }

  public Integer numEdges() {
    // TODO Auto-generated method stub
    return null;
  }

  public Integer numVertices() {
    // TODO Auto-generated method stub
    return null;
  }

  public Iterator<Edge<T>> outgoingEdges() {
    // TODO Auto-generated method stub
    return null;
  }

  public void removeEdge(Edge<T> edge) {
    // TODO Auto-generated method stub

  }
}
