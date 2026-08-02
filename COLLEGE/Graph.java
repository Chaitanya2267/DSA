import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    int vertices;
    List<List<Integer>> adj;

    // Constructor
    Graph(int vertices) {

        this.vertices = vertices;

        adj = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add edge
    void addEdge(int u, int v) {

        adj.get(u).add(v);
        adj.get(v).add(u); // Undirected graph
    }

    // BFS Traversal
    void bfs(int src) {

        boolean[] visited = new boolean[vertices];

        Queue<Integer> q = new LinkedList<>();

        visited[src] = true;
        q.add(src);

        while (!q.isEmpty()) {

            int u = q.poll();

            System.out.print(u + " ");

            for (int neighbor : adj.get(u)) {

                if (!visited[neighbor]) {

                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }

    // DFS Helper
    void dfsHelper(int u, boolean[] visited) {

        visited[u] = true;

        System.out.print(u + " ");

        for (int neighbor : adj.get(u)) {

            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    // DFS Traversal
    void dfs(int src) {

        boolean[] visited = new boolean[vertices];

        dfsHelper(src, visited);
    }

    // Main Method
    public static void main(String[] args) {

        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);

        System.out.print("BFS: ");
        g.bfs(0);

        System.out.println();

        System.out.print("DFS: ");
        g.dfs(0);
    }
}