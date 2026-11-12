package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;

public class BasicGraphHashmap {

  public static void main(String[] args) {

    Map<String, List<String>> graph = new HashMap<>();

//    // Step 1: add vertices in a loop
//    String[] vertices = {"A", "B", "C", "D"};
//    for (String vertex : vertices) {
//      graph.put(vertex, new ArrayList<>());
//    }

    // Step 1: add vertices
    graph.put("A", new ArrayList<>());
    graph.put("B", new ArrayList<>());
    graph.put("C", new ArrayList<>());
    graph.put("D", new ArrayList<>());

    // Step 2: add edges (undirected)
    addEdge(graph, "A", "B");
    addEdge(graph, "A", "C");
    addEdge(graph, "B", "D");
    addEdge(graph, "C", "D");

    bfs(graph, "A");

    // Step 3: print the graph
    printGraph(graph);
  }

  static void bfs(Map<String, List<String>> graph, String start) {
    Set<String> visited = new HashSet<>();
    visited.add(start);

    Queue<String> queue = new LinkedList<>();
    queue.offer(start);

    while (!queue.isEmpty()) {
      String current = queue.poll();
      System.out.print(current + " ");

      for (String neighbor : graph.get(current)) {
        if (!visited.contains(neighbor)) {
          visited.add(neighbor);
          queue.offer(neighbor);
        }
      }
    }
  }
  static void addEdge(Map<String, List<String>> graph, String u, String v) {
    graph.get(u).add(v);
    graph.get(v).add(u);
  }

  static void printGraph(Map<String, List<String>> graph) {
    for (String vertex : graph.keySet()) {
      System.out.println(vertex + " → " + graph.get(vertex));
    }
  }
}