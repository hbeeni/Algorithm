/**
 * Graph에서 두 개의 노드가 서로 찾아갈 수 있는 경로가
 * 있는지 확인하는 함수를 구현하시오.
 */

package datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

class Graph1 {
    class Node {
        int data;
        LinkedList<Node> adjacent;
        boolean marked;

        public Node(int data) {
            this.data = data;
            this.adjacent = new LinkedList<>();
            this.marked = false;
        }
    }

    Node[] nodes;

    public Graph1(int size) {
        this.nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int idx1, int idx2) {
        Node n1 = nodes[idx1];
        Node n2 = nodes[idx2];

        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    boolean search(int idx1, int idx2) {
        return search(nodes[idx1], nodes[idx2]);
    }

    //하나의 Node에서 점차 영역을 넓히면서 찾으니까 bfs가 더 적합할 거 같음
    boolean search(Node n1, Node n2) {
        Queue<Node> q = new LinkedList<>();
        q.add(n1);

        while (!q.isEmpty()) {
            Node r = q.remove();

            if (r == n2) {
                return true;
            }

            for (Node n : r.adjacent) {
                if (!n.marked) {
                    n.marked = true;
                    q.add(n);
                }
            }
        }

        return false;
    }
}


public class Search {
    public static void main(String[] args) {
        /*
          0
         /
        1 -- 3    7
        |  / | \ /
        | /  |  5
        2 -- 4   \
                  6 -- 8
        */
        Graph1 g = new Graph1(9);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);
        System.out.println(g.search(1, 5));
    }
}
