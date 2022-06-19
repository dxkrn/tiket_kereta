package com.tiket_kereta;

// Java Program shows the implementation Dijkstra's Algorithm
// Using the Priority Queue

// import statement
import java.util.*;

// Main class DijkstraExample1
public class Stasiun {

    // Member variables of the class
    private int distance[];
    private Set<Integer> settld;
    private PriorityQueue<Node> pQue;

    // Total count of the vertices
    private int totalNodes;
    List<List<Node>> adjacent;

    // Constructor of the class
    public Stasiun(int totalNodes) {

        this.totalNodes = totalNodes;
        distance = new int[totalNodes];
        settld = new HashSet<Integer>();
        pQue = new PriorityQueue<Node>(totalNodes, new Node());
    }

    public void dijkstra(List<List<Node>> adjacent, int s) {
        this.adjacent = adjacent;

        for (int j = 0; j < totalNodes; j++) {
// initializing the distance of every node to infinity (a large number)
            distance[j] = Integer.MAX_VALUE;
        }

// Adding the source node to pQue
        pQue.add(new Node(s, 0));

// distance of the source is always zero
        distance[s] = 0;

        while (settld.size() != totalNodes) {

// Terminating condition check when
// the priority queue contains zero elements, return
            if (pQue.isEmpty()) {
                return;
            }

// Deleting the node that has the minimum distance from the priority queue
            int ux = pQue.remove().n;

// Adding the node whose distance is
// confirmed
            if (settld.contains(ux)) {
                continue;
            }

// We don't have to call eNeighbors(ux)
// if ux is already present in the settled set.
            settld.add(ux);

            eNeighbours(ux);
        }
    }

    private void eNeighbours(int ux) {

        int edgeDist = -1;
        int newDist = -1;

// All of the neighbors of vx
        for (int j = 0; j < adjacent.get(ux).size(); j++) {
            Node vx = adjacent.get(ux).get(j);

// If the current node hasn't been already processed
            if (!settld.contains(vx.n)) {
                edgeDist = vx.price;
                newDist = distance[ux] + edgeDist;

                // If the new distance is lesser in the cost
                if (newDist < distance[vx.n]) {
                    distance[vx.n] = newDist;
                }

                // Adding the current node to the priority queue pQue
                pQue.add(new Node(vx.n, distance[vx.n]));
            }
        }
    }

    public int getDistance(int tujuan) {
        return distance[tujuan];
    }
}

// The Node class implementing the Comparator interface
// The object of this class represents a node of the graph
class Node implements Comparator<Node> {

    // Member variables of the Node class
    public int n;
    public int price;

// Constructors of this class

    // Constructor 1
    public Node() {

    }

    // Constructor 2
    public Node(int n, int price) {
        this.n = n;
        this.price = price;
    }

    @Override
    public int compare(Node n1, Node n2) {

        if (n1.price < n2.price) {
            return -1;
        }
        if (n1.price > n2.price) {
            return 1;
        }

        return 0;
    }
}

