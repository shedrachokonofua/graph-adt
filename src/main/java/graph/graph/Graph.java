package graph.graph;

import java.util.Iterator;

import graph.edge.DirectedEdge;
import graph.edge.Edge;
import graph.vertex.Vertex;

public interface Graph<T> {
  Integer numVertices();
  Integer numEdges();

  Iterator<Vertex<T>> getVertices();
  Iterator<Edge<T>> getEdges();
  Edge<T> getEdge(Vertex<T> u, Vertex<T> v);

  void insertEdge(Edge<T> edge);
  void insertEdge(DirectedEdge<T> edge);
  void removeEdge(Edge<T> edge);

  void insertVertex(Vertex<T> vertex);
  void removeVertex(Vertex<T> vertex);

  Iterator<Edge<T>> outgoingEdges();
  Iterator<Edge<T>> incomingEdges();
}