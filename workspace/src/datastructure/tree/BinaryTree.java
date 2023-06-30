/**
 *        (1)
 *       ↙    ↘
 *     (2)    (3)
 *    ↙   ↘
 *  (4)   (5)
 *
 *  Inorder (Left, Root, Right): 4 2 5 1 3
 *  Preorder (Root, Left, Right): 1 2 4 5 3
 *  PostOrder (Left, Right, Root): 4 5 2 3 1
 */

package datastructure.tree;

public class BinaryTree {

    Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node makeNode(Node left, int data, Node right) {
        Node node = new Node();
        node.data = data;
        node.left = left;
        node.right = right;
        return node;
    }

    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node + " ");
            inorder(node.right);
        }
    }

    public void preorder(Node node) {
        if (node != null) {
            System.out.print(node + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node + " ");
        }
    }
}
