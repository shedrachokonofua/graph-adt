import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import graph.AdjacencyListGraph;
import graph.Edge;
import graph.Vertex;
import utils.Pair;

class Driver {

  AdjacencyListGraph<Integer, String> graph;
  Vertex<Integer> start;

  Driver (String fileName, String action, Integer startInteger) {
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
    String action,
    AdjacencyListGraph<Integer, String> graph,
    Vertex<Integer> start
  ) {
    switch(action) {
      case "DFS":
        this.doDFS(graph, start);
        break;
      case "BFS":
        this.doBFS(graph, start);
        break;
      case "PATH":
        this.doPath(graph, start);
        break;
    }
  }

  static void printVertexList (List<Vertex<Integer>> list) {
    ArrayList<String> values = new ArrayList<>();
    for (Vertex<Integer> vertex : list) {
      values.add(Integer.toString(vertex.getValue()));
    }
    System.out.println(String.join(" -> ", values));
  }

  void doDFS (
    AdjacencyListGraph<Integer, String> graph,
    Vertex<Integer> start
  ) {
    ArrayList<Vertex<Integer>> visited = graph.dfs(start);
    Driver.printVertexList(visited);
  }

  void doBFS (
    AdjacencyListGraph<Integer, String> graph,
    Vertex<Integer> start
  ) {
    ArrayList<Vertex<Integer>> visited = graph.bfs(start);
    Driver.printVertexList(visited);
  }

  void doPath(
    AdjacencyListGraph<Integer, String> graph,
    Vertex<Integer> start
  ) {
    Scanner input = new Scanner(System.in);
    System.out.print("Destination Vertex: ");
    Integer desinationValue = input.nextInt();

    Vertex<Integer> destination = new Vertex<Integer>(desinationValue);
    LinkedList<Vertex<Integer>> path = graph.findPath(start, destination);
    if (path == null) {
      System.out.println("Path not found");
    } else {
      Driver.printVertexList(path);
    }
    input.close();
  }

  public static void main(String[] args) {
    if (args.length < 3) {
      System.out.println("Incomplete args");
      return;
    }

    String fileName = args[0];
    String action = args[1];
    Integer start = Integer.parseInt(args[2]);

    if (!isValidAction(action)) {
      System.out.println("Invalid Action");
      return;
    }

    new Driver(fileName, action, start);
  }

  static boolean isValidAction (String action) {
    return (
      action.equals("BFS") ||
      action.equals("DFS") ||
      action.equals("PATH")
    );
  }

}