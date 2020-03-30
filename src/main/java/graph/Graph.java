package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public abstract class Graph<T, E> {

  abstract public Vertex<T> insertVertex (T element);
  abstract public Vertex<T> insertVertex (Vertex<T> vertex);
  abstract public void removeVertex (Vertex<T> vertex);

  abstract public Integer numVertices ();
  abstract public Integer numEdges ();

  abstract public Iterable<Vertex<T>> getVertices ();
  abstract public Iterable<Edge<T, E>> getEdges ();

  abstract public boolean hasVertex (Vertex<T> vertex);

  abstract public Edge<T, E> getEdge (Vertex<T> u, Vertex<T> v);
  abstract public Edge<T, E> getEdge (Edge<T, E> edge);

  abstract public void insertEdge (Vertex<T> u, Vertex<T> v);
  abstract public void insertEdge (Vertex<T> u, Vertex<T> v, E element);
  abstract public void insertEdge (Edge<T, E> edge);

  abstract public void removeEdge (Edge<T, E> edge);

  abstract public Iterable<Edge<T, E>> getOutgoingEdges (Vertex<T> vertex);
  abstract public Iterable<Edge<T, E>> getIncomingEdges (Vertex<T> vertex);

  public ArrayList<Vertex<T>> dfs (Vertex<T> start) {
    ArrayList<Vertex<T>> visited = new ArrayList<Vertex<T>>();
    Stack<Vertex<T>> stack = new Stack<Vertex<T>>();

    stack.push(start);

    while (!stack.isEmpty()) {
      Vertex<T> vertex = stack.pop();

      if (visited.contains(vertex)) continue;

      visited.add(vertex);

      Iterable<Edge<T, E>> outgoingEdges = this.getOutgoingEdges(vertex);
      for(Edge<T, E> edge : outgoingEdges) {
        Vertex<T> destination = edge.getV();
        destination.log();
        stack.push(destination);
      }
    }
    return visited;
  }

  public HashMap<Vertex<T>, Edge<T, E>> bfs (Vertex<T> start) {
    HashMap<Vertex<T>, Edge<T, E>> forest = new HashMap<Vertex<T>, Edge<T, E>>();
    ArrayList<Vertex<T>> visited = new ArrayList<Vertex<T>>();
    LinkedList<Vertex<T>> queue = new LinkedList<Vertex<T>>();

    queue.push(start);
    
    while (!queue.isEmpty()) {
      Vertex<T> vertex = queue.poll();

      if (visited.contains(vertex)) continue;

      visited.add(vertex);

      Iterable<Edge<T, E>> outgoingEdges = this.getOutgoingEdges(vertex);
      for(Edge<T, E> edge : outgoingEdges) {
        Vertex<T> destination = edge.getV();
  
        if (!visited.contains(destination)) {
          forest.put(destination, edge);
          queue.push(destination);
        }
      }
    }
    
    return forest; 
  }

  public LinkedList<Edge<T, E>> findPath (Vertex<T> origin, Vertex<T> target) {
    HashMap<Vertex<T>, Edge<T, E>> forest = this.bfs(origin);
    LinkedList<Edge<T, E>> queue = new LinkedList<Edge<T, E>>();
    if (forest.containsKey(target)) {
      Vertex<T> currentVertex = target;

      while (!currentVertex.equals(origin)) {
        Edge<T, E> edge = forest.get(currentVertex);
        queue.addFirst(edge);
        currentVertex = edge.getOpposite(currentVertex);
      }
    }
    return queue;
  }
}