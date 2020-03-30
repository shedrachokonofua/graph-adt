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
        stack.push(destination);
      }
    }
    return visited;
  }

  public ArrayList<Vertex<T>> bfs (Vertex<T> start) {
    ArrayList<Vertex<T>> visited = new ArrayList<Vertex<T>>();
    LinkedList<Vertex<T>> queue = new LinkedList<Vertex<T>>();

    queue.push(start);
    visited.add(start);

    while(!queue.isEmpty()) {
      Vertex<T> vertex = queue.poll();
      Iterable<Edge<T, E>> outgoingEdges = this.getOutgoingEdges(vertex);
      for(Edge<T, E> edge : outgoingEdges) {
        Vertex<T> destination = edge.getV();
        if (!visited.contains(destination)) {
          queue.push(destination);
          visited.add(destination);
        }
      }
    }

    return visited;
  }

  public LinkedList<Vertex<T>> findPath (Vertex<T> origin, Vertex<T> target) {
    ArrayList<Vertex<T>> visited = new ArrayList<Vertex<T>>();
    Stack<LinkedList<Vertex<T>>> pathStack = new Stack<LinkedList<Vertex<T>>>();
    LinkedList<Vertex<T>> initialPath = new LinkedList<Vertex<T>>();
    initialPath.add(origin);
    pathStack.push(initialPath);

    while (!pathStack.isEmpty()) {
      LinkedList<Vertex<T>> currentPath = pathStack.pop();
      Vertex<T> currentVertex = currentPath.getLast();

      if (target.equals(currentVertex)) return currentPath;
      if (visited.contains(currentVertex)) continue;
      
      visited.add(currentVertex);

      Iterable<Edge<T, E>> outgoingEdges = this.getOutgoingEdges(currentVertex);
      for(Edge<T, E> edge : outgoingEdges) {
        Vertex<T> destination = edge.getV();
        LinkedList<Vertex<T>> newPath = (LinkedList<Vertex<T>>) currentPath.clone();
        newPath.add(destination);
        pathStack.push(newPath);
      }
    }

    return null;
    
  }
}