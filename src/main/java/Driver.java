import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import graph.*;
import graph.utils.Pair;

class Driver {
  private enum Action {
    DFS,
    BFS,
    PATH
  };

  AdjacencyListGraph<Integer, String> graph;
  Vertex<Integer> start;

  Driver (String fileName, Action action, Integer startInteger) {
    ArrayList<Pair<Integer, Integer>> pairs = this.loadFile(fileName);

    if (pairs == null) return;

    AdjacencyListGraph<Integer, String> graph = buildGraphFromPairs(pairs);
    Vertex<Integer> start = new Vertex<Integer>(startInteger);
    this.doAction(action, graph, start);
  }

  ArrayList<Pair<Integer, Integer>> loadFile (String fileName) {
    try {
      ArrayList<Pair<Integer, Integer>> pairs = new ArrayList<Pair<Integer, Integer>>();
      File fileObject = new File(fileName);
      Scanner fileReader = new Scanner(fileObject);
      while (fileReader.hasNextLine()) {
        String line = fileReader.nextLine();
        String[] parts = line.split(" ");
        Integer u = Integer.parseInt(parts[0]);
        Integer v = Integer.parseInt(parts[1]);
        pairs.add(new Pair<Integer, Integer>(u, v));
      }
      fileReader.close();
      return pairs;
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
      return null;
    }
  }

  AdjacencyListGraph<Integer, String> buildGraphFromPairs (ArrayList<Pair<Integer, Integer>> pairs) {
    AdjacencyListGraph<Integer, String> graph = new AdjacencyListGraph<Integer, String>();

    for (Pair<Integer, Integer> pair : pairs) {
      Vertex<Integer> u = graph.insertVertex(pair.getLeft());
      Vertex<Integer> v = graph.insertVertex(pair.getRight());
      graph.insertEdge(u, v);
    }

    return graph;
  }

  void doAction(
    Action action,
    AdjacencyListGraph<Integer, String> graph,
    Vertex<Integer> start
  ) {
    switch(action) {
      case DFS:
        this.doDFS(graph, start);
        break;
      case BFS:
        this.doBFS(graph, start);
        break;
      case PATH:
        this.doPath(graph, start);
        break;
    }
  }

  void doDFS (
    AdjacencyListGraph<Integer, String> graph,
    Vertex<Integer> start
  ) {
    ArrayList<Vertex<Integer>> visited = graph.dfs(start);
    for (Vertex<Integer> vertex : visited) {
      
    }
  }

}