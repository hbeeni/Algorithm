/**
 * 이진트리의 노드들을 각 레벨별로 LinkedList에 담는 알고리즘을 구현하시오.
 * 예를 들어, 5개의 깊이를 가지는 트리라면 5개의 LinkedList를 만들어야 함
 */

package datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;

class OriginalTree {

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data + "";
        }
    }

    Node root;

    public OriginalTree(int size) {
        root = makeBST(0, size - 1);
    }

    private Node makeBST(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node n = new Node(mid);

        n.left = makeBST(start, mid - 1);
        n.right = makeBST(mid + 1, end);

        return n;
    }

    ArrayList<LinkedList<Node>> BSTtoList() {
        ArrayList<LinkedList<Node>> lists = new ArrayList<>();
        BSTtoList(root, lists, 0);
        return lists;
    }

    void BSTtoList(Node root, ArrayList<LinkedList<Node>> lists, int level) {
        if (root == null) {
            return;
        }

        LinkedList<Node> ll;

        if (lists.size() <= level) {
            ll = new LinkedList<>();
            lists.add(ll);
        } else {
            ll = lists.get(level);
        }

        ll.add(root);
        BSTtoList(root.left, lists, level + 1);
        BSTtoList(root.right, lists, level + 1);
    }

    //bfs 변형
    ArrayList<LinkedList<Node>> BSTtoList2() {
        ArrayList<LinkedList<Node>> result = new ArrayList<>();

        LinkedList<Node> current = new LinkedList<>();
        if (root != null) {
            current.add(root);
        }

        while (current.size() > 0) {
            result.add(current);

            LinkedList<Node> parents = current;
            current = new LinkedList<>();

            for (Node parent : parents) {
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }

        return result;
    }
}

/*
        4
   1          7
 0    2     5    8
        3     6    9
 */
public class TreeToLinkedList {

    static void printList(ArrayList<LinkedList<OriginalTree.Node>> lists) {
        lists.forEach(System.out::println);
    }

    public static void main(String[] args) {
        OriginalTree tree = new OriginalTree(10);
        printList(tree.BSTtoList());
    }
}
