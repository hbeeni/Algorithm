/**
 * 주어진 트리가 이진검색트리인지를 확인하는 함수를 구현하시오.
 */

package datastructure.tree;

import java.util.ArrayList;
import java.util.List;

class CheckTree {
    Node root;
    int size;

    public CheckTree(int size) {
        this.size = size;
        root = makeBST(0, size - 1);
//        root.right.right.right.left = new Node(10);
//        this.size++;
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

    //리스트, 배열 사용 (추가 공간)
    boolean isValidateBST1() {
        List<Node> list = new ArrayList<>(size);

        inorder(list, root);

        for (int i = 0; i < list.size() -1; i++) {
            int data1 = list.get(i).data;
            int data2 = list.get(i + 1).data;

            if (data1 > data2) {
                return false;
            }
        }

        return true;
    }

    void inorder(List<Node> list, Node node) {
        if (node != null) {
            inorder(list, node.left);
            list.add(node);
            inorder(list, node.right);
        }
    }

    //엔지니어 대한민국
    boolean isValidateBST2() {
        int[] arr = new int[size];

        inorder2(arr, root);

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }

    int index;

    void inorder2(int[] arr, Node node) {
        if (node != null) {
            inorder2(arr, node.left);
            arr[index] = node.data;
            index++;
            inorder2(arr, node.right);
        }
    }

    //배열, 리스트 사용 x
    Integer last_printed = null;

    boolean isValidateBST3() {
        return isValidateBST3(root);
    }

    boolean isValidateBST3(Node n) {
        if (n == null) {
            return true;
        }

        if (!isValidateBST3(n.left)) {
            return false;
        }
        if (last_printed != null && n.data < last_printed) {
            return false;
        }

        last_printed = n.data;
        if (!isValidateBST3(n.right)) {
            return false;
        }

        return true;
    }

    //min, max 사용
    boolean isValidateBST4() {
        return isValidateBST4(root, Integer.MIN_VALUE ,Integer.MAX_VALUE);
    }

    boolean isValidateBST4(Node n, int min, int max) {
        if (n == null) {
            return true;
        }
        if (n.data < min || n.data > max) {
            return false;
        }
        if (!isValidateBST4(n.left, min, n.data) ||
                !isValidateBST4(n.right, n.data, max)) {
            return false;
        }
        return true;
    }
}

public class BinaryTreeCheck {
    public static void main(String[] args) {
        CheckTree tree = new CheckTree(10);
        System.out.println("V1: " + tree.isValidateBST1());
        System.out.println("V2: " + tree.isValidateBST2());
        System.out.println("V3: " + tree.isValidateBST3());
        System.out.println("V4: " + tree.isValidateBST4());
    }
}
