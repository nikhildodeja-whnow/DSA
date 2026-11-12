package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class BasicGraphArray {

  public static void main(String[] args) {

    int n = 4; // number of vertices: 0, 1, 2, 3

    // Step 1: create array of lists
    List<Integer>[] graph = new ArrayList[n];

    // Step 2: initialize each slot with empty list
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    // Step 3: add edges (undirected)
    addEdge(graph, 0, 1);
    addEdge(graph, 0, 2);
    addEdge(graph, 1, 3);
    addEdge(graph, 2, 3);

    // Step 4: print the graph
    printGraph(graph, n);

    System.out.println("BFS");
    bfs(graph, 0);

    bfs1(graph, 3);

    boolean[] visited = new boolean[4];
    System.out.println("\nDFS");
    dfs(graph, 0, visited);

    System.out.println("\n Dfs Interactive");
    dfsIterative(graph, 2);

    boolean result = hasCycle(graph, n);
    System.out.println("\nHas cycle: " + result);
  }
  static void bfs (List<Integer> [] graph, int start) {
    boolean[] visitedVertex = new boolean[4];
    visitedVertex[start] = true;
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    while(!queue.isEmpty()) {
      int current = queue.poll();
      System.out.print(current + " - ");
      for(int i = 0; i < graph[current].size(); i++) {
        int neighbor = graph[current].get(i);
        if (!visitedVertex[neighbor]) {
          visitedVertex[neighbor] = true;
          queue.offer(neighbor);
        }
      }
    }
  }



  static void bfs1(List<Integer>[] graph, int start) {
    boolean[] visited = new boolean[4];
    visited[start] = true;

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);

    while (!queue.isEmpty()) {
      int current = queue.poll();
      System.out.print(current + " ");

      for (int neighbor : graph[current]) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          queue.offer(neighbor);
        }
      }
    }
  }

  static void dfs(List<Integer>[] graph, int vertex, boolean[] visited) {
    int current = vertex;
    visited[current] = true;
    System.out.print(current + " ");

    for (int neighbor : graph[current]) {
      if (!visited[neighbor]) {
        dfs(graph, neighbor, visited);
      }
    }
  }

  static boolean hasCycle(List<Integer>[] graph, int n) {
    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        if (dfsHasCycle(graph, i, visited, -1)) {
          return true;
        }
      }
    }
    return false;
  }

  static boolean dfsHasCycle(List<Integer>[] graph, int vertex, boolean[] visited, int parent) {
    visited[vertex] = true;

    for (int neighbor : graph[vertex]) {
      if (!visited[neighbor]) {
        if (dfsHasCycle(graph, neighbor, visited, vertex)) {
          return true;
        }
      } else if (neighbor != parent) {
        return true;
      }
    }
    return false;
  }

  static void dfsIterative(List<Integer>[] graph, int start) {
    boolean[] visited = new boolean[4];

    Stack<Integer> stack = new Stack<>();
    stack.push(start);

    while (!stack.isEmpty()) {
      int current = stack.pop();

      if (!visited[current]) {
        visited[current] = true;
        System.out.print(current + " ");

        for (int neighbor : graph[current]) {
          if (!visited[neighbor]) {
            stack.push(neighbor);
          }
        }
      }
    }
  }

  // adds edge between u and v in both directions
  static void addEdge(List<Integer>[] graph, int u, int v) {
    graph[u].add(v);
    graph[v].add(u);
  }

  // prints each vertex and its neighbors
  static void printGraph(List<Integer>[] graph, int n) {
    for (int i = 0; i < n; i++) {
      System.out.println(i + " → " + graph[i]);
    }
  }
}