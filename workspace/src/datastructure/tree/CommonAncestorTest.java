/**
 * 이진트리에서 주어진 두개의 노드의 첫번째 공통된 부모 노드를 찾으시오.
 * (단, 다른 자료구조는 사용 금지)
 */

package datastructure.tree;

import java.util.HashMap;

class CATree {
    static class Node {
        int data;
        Node left;
        Node right;
        Node parent;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data + "";
        }
    }

    Node root;
    HashMap<Integer, Node> rootMap;

    public CATree(int size) {
        this.rootMap = new HashMap<>();
        root = makeBST(0, size - 1, null);
    }

    private Node makeBST(int start, int end, Node parent) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node node = new Node(mid);
        node.left = makeBST(start, mid - 1, node);
        node.right = makeBST(mid + 1, end, node);
        node.parent = parent;
        rootMap.put(mid, node);
        return node;
    }

    Node getNode(int data) {
        return rootMap.get(data);
    }

    /**
     * 두 노드의 깊이를 맞춰준 후 같이 위로 올라가면서 공통부모 찾기
     * O(d) d: 깊이
     * 내가 작성
     */
    Node commonAncestor(int d1, int d2) {
        Node n1 = getNode(d1);
        Node n2 = getNode(d2);

        int depth1 = getDepth(n1);
        int depth2 = getDepth(n2);

        while (depth1 > depth2) {
            n1 = n1.parent;
            depth1--;
        }
        while (depth1 < depth2) {
            n2 = n2.parent;
            depth2--;
        }

        while (n1 != n2) {
            n1 = n1.parent;
            n2 = n2.parent;
        }

        return n1;
    }

    private int getDepth(Node node) {
        int depth = 1;

        while (node != root) {
            depth++;
            node = node.parent;
        }

        return depth;
    }

    //엔지니어 대한민국
    Node commonAncestorV2(int d1, int d2) {
        Node p = getNode(d1);
        Node q = getNode(d2);
        int diff = depth(p) - depth(q);

        Node first = diff > 0 ? q : p; //짧은 쪽
        Node second = diff > 0 ? p : q; //긴 쪽

        second = goUpBy(second, Math.abs(diff));

        while (first != second && first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }

        return first == null || second == null ? null : first;
    }

    private int depth(Node node) {
        int depth = 0;

        while (node != null) {
            node = node.parent;
            depth++;
        }

        return depth;
    }

    private Node goUpBy(Node node, int diff) {
        while (diff > 0 && node != null) {
            node = node.parent;
            diff--;
        }

        return node;
    }

    /**
     * 한 노드를 기준으로 한 칸씩 올라가서 자손에 다른 노드가 있는지 찾기
     * O(t) t: 첫번째 공통부모의 서브트리의 개수
     * node가 root의 자손인지 확인
     */
    boolean covers(Node root, Node node) {
        if (root == null) {
            return false;
        }
        if (root == node) {
            return true;
        }

        return covers(root.left, node) || covers(root.right, node);
    }

    Node commonAncestorV3(int d1, int d2) {
        Node p = getNode(d1);
        Node q = getNode(d2);

        if (!covers(root, p) || !covers(root, q)) {
            return null;
        } else if (covers(p, q)) {
            return p;
        } else if (covers(q, p)) {
            return q;
        }

        Node sibling = getSibling(p);
        Node parent = p.parent;
        while (!covers(sibling, q)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }

        return parent;
    }

    private Node getSibling(Node node) {
        if (node == null || node.parent == null) {
            return null;
        }

        Node parent = node.parent;
        return parent.left == node ? parent.right : parent.left;
    }

    /**
     * parent를 모른다고 가정 시
     * root에서부터 내려오면서 양쪽 서브트리를 비교
     * 양쪽에 각 노드가 하나씩 있는 처음 노드가 첫번째 공통 부모
     */
    Node commonAncestorV4(int d1, int d2) {
        Node p = getNode(d1);
        Node q = getNode(d2);

        if (!covers(root, p) || !covers(root, q)) {
            return null;
        }

        return ancestorHelper(root, p, q);
    }

    private Node ancestorHelper(Node root, Node p, Node q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        boolean pIsOnLeft = covers(root.left, p);
        boolean qIsOnLeft = covers(root.left, q);

        if (pIsOnLeft != qIsOnLeft) { //같은 쪽에 있지 않으면 root가 첫번째 공통 부모
            return root;
        }

        Node childSide = pIsOnLeft ? root.left : root.right;
        return ancestorHelper(childSide, p, q);
    }
}

/*
        4
   1          7
 0    2     5    8
        3     6    9
 */

public class CommonAncestorTest {
    public static void main(String[] args) {
        CATree t = new CATree(10);
        System.out.println(t.commonAncestorV4(3, 5));
        System.out.println(t.commonAncestorV4(0, 2));
        System.out.println(t.commonAncestorV4(6, 7));
        System.out.println(t.commonAncestorV4(6, 8));
    }
}
