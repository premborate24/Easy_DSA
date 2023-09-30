/*
 *   Breadth first search
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch_BFS {

    static class Edge {
        int src;
        int dest;
        int weight;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0); // source=0

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void creatGraphs(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 vertex
        graph[0].add(new Edge(0, 1, 5));

        // 1 vertex
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2 vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        // 3 vertex
        graph[3].add(new Edge(3, 2, 1));
        graph[3].add(new Edge(3, 1, 3));

        // 4 vertex
        graph[4].add(new Edge(4, 2, 2));

    }

    public static void main(String[] args) {

        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];

        creatGraphs(graph);

        bfs(graph);
    }
}

/*
 * Output:
 * 0 1 2 3 4
 */


// How does BFS work?
// Starting from the root, all the nodes at a particular level are visited first and then the nodes of the next level are traversed till all the nodes are visited.

// To do this a queue is used. All the adjacent unvisited nodes of the current level are pushed into the queue and the nodes of the current level are marked visited and popped from the queue.

// Illustration:

// Let us understand the working of the algorithm with the help of the following example.

// Step1: Initially queue and visited arrays are empty.


// Queue and visited arrays are empty initially.

// Step2: Push node 0 into queue and mark it visited.

// Push node 0 into queue and mark it visited.
// Push node 0 into queue and mark it visited.

// Step 3: Remove node 0 from the front of queue and visit the unvisited neighbours and push them into queue.

// Remove node 0 from the front of queue and visited the unvisited neighbours and push into queue.
// Remove node 0 from the front of queue and visited the unvisited neighbours and push into queue.

// Step 4: Remove node 1 from the front of queue and visit the unvisited neighbours and push them into queue.

// Remove node 1 from the front of queue and visited the unvisited neighbours and push
// Remove node 1 from the front of queue and visited the unvisited neighbours and push

// Step 5: Remove node 2 from the front of queue and visit the unvisited neighbours and push them into queue.

// Remove node 2 from the front of queue and visit the unvisited neighbours and push them into queue.
// Remove node 2 from the front of queue and visit the unvisited neighbours and push them into queue.

// Step 6: Remove node 3 from the front of queue and visit the unvisited neighbours and push them into queue. 
// As we can see that every neighbours of node 3 is visited, so move to the next node that are in the front of the queue.

// Remove node 3 from the front of queue and visit the unvisited neighbours and push them into queue. 
// Remove node 3 from the front of queue and visit the unvisited neighbours and push them into queue. 

// Steps 7: Remove node 4 from the front of queue and visit the unvisited neighbours and push them into queue. 
// As we can see that every neighbours of node 4 are visited, so move to the next node that is in the front of the queue.

// Remove node 4 from the front of queue and and visit the unvisited neighbours and push ithem into queue. 
// Remove node 4 from the front of queue and visit the unvisited neighbours and push them into queue.

// Now, Queue becomes empty, So, terminate these process of iteration.

// Implementation of BFS for Graph using Adjacency List:

// #include <stdbool.h>
// #include <stdio.h>
// #include <stdlib.h>
 
// #define MAX_VERTICES 50
 
// // This struct represents a directed graph using
// // adjacency list representation
// typedef struct Graph_t {
 
//     // No. of vertices
//     int V;
//     bool adj[MAX_VERTICES][MAX_VERTICES];
// } Graph;
 
// // Constructor
// Graph* Graph_create(int V)
// {
//     Graph* g = malloc(sizeof(Graph));
