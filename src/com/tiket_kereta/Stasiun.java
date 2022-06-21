package com.tiket_kereta;

import java.util.*;

@SuppressWarnings("FieldMayBeFinal")
public class Stasiun {

    private int[] distance;
    private Set<Integer> settld;
    private PriorityQueue<Node> pQue;

    // Jumlah total vertices
    private int totalNodes;
    List<List<Node>> adjacent;

    //Constructor
    public Stasiun(int totalNodes) {

        this.totalNodes = totalNodes;
        distance = new int[totalNodes];
        settld = new HashSet<>();
        pQue = new PriorityQueue<>(totalNodes, new Node());
    }

    public void dijkstra(List<List<Node>> adjacent, int s) {
        this.adjacent = adjacent;

        for (int j = 0; j < totalNodes; j++) {
            distance[j] = Integer.MAX_VALUE;
        }

        //Menambahkan src node ke pQue
        pQue.add(new Node(s, 0));

        //jarak src = 0
        distance[s] = 0;

        while (settld.size() != totalNodes) {


            if (pQue.isEmpty()) {
                return;
            }

            //menghapus node dengan jarak minimum dari pQue
            int ux = pQue.remove().n;

            //menambhkan node
            if (settld.contains(ux)) {
                continue;
            }


            settld.add(ux);

            eNeighbours(ux);
        }
    }

    @SuppressWarnings("UnusedAssignment")
    private void eNeighbours(int ux) {

        int edgeDist = -1;
        int newDist = -1;

        //semua tetangga vx
        for (int j = 0; j < adjacent.get(ux).size(); j++) {
            Node vx = adjacent.get(ux).get(j);

            if (!settld.contains(vx.n)) {
                edgeDist = vx.price;
                newDist = distance[ux] + edgeDist;

                if (newDist < distance[vx.n]) {
                    distance[vx.n] = newDist;
                }

                pQue.add(new Node(vx.n, distance[vx.n]));
            }
        }
    }

    public int getDistance(int tujuan) {
        return distance[tujuan];
    }
}

class Node implements Comparator<Node> {

    public int n;
    public int price;

    public Node() {

    }

    public Node(int n, int price) {
        this.n = n;
        this.price = price;
    }

    @SuppressWarnings("UseCompareMethod")
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

