/**
 * 이진검색트리에서 주어진 노드의 다음노드를 찾는 함수를 구현하시오.
 * (단, 다음노드의 순서는 inorder traverse에 입각함)
 */

package datastructure.tree;

class NNTree {
    class Node {
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

    public NNTree(int size) {
        this.root = makeBST(0, size - 1, null);
    }

    private Node makeBST(int start, int end, Node parent) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node n = new Node(mid);

        n.left = makeBST(start, mid - 1, n);
        n.right = makeBST(mid + 1, end, n);
        n.parent = parent;

        return n;
    }

    void findNextNode(Node node) {
        if (node.right == null) {
            System.out.println(findAbove(node.parent, node) + " is " +
                    node + "'s next");
        } else {
            System.out.println(findBelow(node.right) + " is " +
                    node + "'s next");
        }
    }

    Node findAbove(Node root, Node child) {
        if (root == null) {
            return null;
        }
        if (root.left == child) {
            return root;
        }
        return findAbove(root.parent, root);
    }

    Node findBelow(Node root) {
        if (root.left == null) {
            return root;
        }
        return findBelow(root.left);
    }
}

/*
        4
   1          7
 0    2     5    8
        3     6    9
 */
public class FindNextNodeTest {
    public static void main(String[] args) {
        NNTree tree = new NNTree(10);
        tree.findNextNode(tree.root.left.right.right);
        tree.findNextNode(tree.root.left);
        tree.findNextNode(tree.root);
        tree.findNextNode(tree.root.left.left);
        tree.findNextNode(tree.root.right.left.right);
    }
}
