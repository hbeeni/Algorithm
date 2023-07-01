package datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class Graph {
    class Node {
        int data;
        LinkedList<Node> adjacent;
        boolean marked; //방문했는지

        public Node(int data) {
            this.data = data;
            this.marked = false;
            this.adjacent = new LinkedList<>();
        }
    }

    Node[] nodes;

    public Graph(int size) {
        this.nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    //두 노드의 관계 저장
    void addEdge(int idx1, int idx2) {
        Node n1 = nodes[idx1];
        Node n2 = nodes[idx2];

        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.addLast(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.addLast(n1);
        }
    }

    void dfs() {
        dfs(0);
    }

    /**
     * 1. Stack에 넣고, 방문처리
     * 2. Stack에서 꺼내기 
     * 3. 방문하지 않은 인접 노드 Stack에 넣기
     * 4. 출력
     * -> 나중에 넣은 Node부터
     */
    void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;

        while (!stack.empty()) {
            Node r = stack.pop();

            for (Node n : r.adjacent) {
                if (!n.marked) {
                    n.marked = true;
                    stack.push(n);
                }
            }

            visit(r);
        }
    }

    void dfsRecur() {
        dfsRecur(0);
    }

    /**
     * 1. 방문처리
     * 2. 출력
     * 3. 방문하지 않은 인접 노드 재귀호출
     * -> 먼저 넣은 Node부터
     */
    void dfsRecur(Node r) {
        if (r == null) {
            return;
        }

        r.marked = true;
        visit(r);

        for (Node n : r.adjacent) {
            if (!n.marked) {
                dfsRecur(n);
            }
        }
    }

    void dfsRecur(int index) {
        Node r = nodes[index];
        dfsRecur(r);
    }

    void bfs() {
        bfs(0);
    }

    /**
     * 1. Queue에 넣고, 방문처리
     * 2. Queue에서 꺼내기
     * 3. 방문하지 않은 인접 노드 Queue에 넣기
     * 4. 출력
     */
    void bfs(int index) {
        Node root = nodes[index];
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        root.marked = true;

        while (!queue.isEmpty()) {
            Node r = queue.remove();

            for (Node n : r.adjacent) {
                if (!n.marked) {
                    n.marked = true;
                    queue.add(n);
                }
            }

            visit(r);
        }
    }

    void visit(Node node) {
        System.out.print(node.data + " ");
    }
}

/*
  0
 /
1 -- 3    7
|  / | \ /
| /  |  5
2 -- 4   \
          6 -- 8
--------------------
dfs(0)
0 1 3 5 7 6 8 4 2
dfsRecur(0)
0 1 2 4 3 5 6 8 7
bfs(0)
0 1 2 3 4 5 6 7 8
---------------------
dfs(3)
3 5 7 6 8 4 2 1 0
dfsRecur(3)
3 1 0 2 4 5 6 8 7
bfs(3)
3 1 2 4 5 0 6 7 8
 */
public class BfsDfs {
    public static void main(String[] args) {
        Graph g = new Graph(9);
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
        
//        g.dfs(0);
//        g.dfsRecur(0);
//        g.bfs(0);
//        g.dfs(3);
//        g.dfsRecur(3);
        g.bfs(3);
    }
}
