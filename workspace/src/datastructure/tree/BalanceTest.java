/**
 * 주어진 이진트리의 Balance가 맞는지 확인하는 함수를 구현하시오.
 * (여기서 Balance가 맞다는 의미는 어떤 노드의 양 쪽 서브트리의 (가장 긴) 길이가
 * 1 이상 차이가 나지 않는 것을 뜻함)
 */

package datastructure.tree;

class BalanceTestTree {
    Node root;

    public BalanceTestTree(int size) {
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

    //O(NlogN)
    boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }

        int heightDiff = getHeight(root.left) - getHeight(root.right);

        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int getHeight(Node root) {
        if (root == null) {
            return -1;
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}

public class BalanceTest {
    public static void main(String[] args) {
        BalanceTestTree tree = new BalanceTestTree(10);
        System.out.println(tree.isBalanced(tree.root));
    }
}
