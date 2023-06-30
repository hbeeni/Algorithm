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

public class OrderTest {
    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        Node n4 = t.makeNode(null, 4, null);
        Node n5 = t.makeNode(null, 5, null);
        Node n2 = t.makeNode(n4, 2, n5);
        Node n3 = t.makeNode(null, 3, null);
        Node n1 = t.makeNode(n2, 1, n3);
        t.setRoot(n1);
        System.out.println("[inorder]");
        t.inorder(t.getRoot());
        System.out.println("\n[preorder]");
        t.preorder(t.getRoot());
        System.out.println("\n[postorder]");
        t.postorder(t.getRoot());
    }
}
