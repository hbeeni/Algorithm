/**
 * 정렬이 되어 있고, 고유한 정수로만 이루어진 배열이 있다.
 * 이 배열로 이진검색트리를 구현하시오.
 */

package datastructure.tree;

class Tree {

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

    //내가 작성
    void arrayToTree(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;
        root = new Node(arr[mid]);

        arrayToTree(root, arr, start, mid - 1);
        arrayToTree(root, arr, mid + 1, end);
    }

    void arrayToTree(Node root, int[] arr, int start, int end) {
        if (start > end) {
            return;
        }

        int mid = (start + end) / 2;
        Node n = new Node(arr[mid]);

        if (n.data < root.data) {
            root.left = n;
        } else {
            root.right = n;
        }

        root = n;
        arrayToTree(root, arr, start, mid - 1);
        arrayToTree(root, arr, mid + 1, end);
    }

    boolean search(int num) {
        Node n = root;

        while (n != null) {
            System.out.print(n.data + " ");

            if (n.data == num) {
                return true;
            } else if (n.data < num) {
                n = n.right;
            } else {
                n = n.left;
            }
        }

        return false;
    }

    //엔지니어 대한민국
    void makeTree(int[] a) {
        root = makeTree(a, 0, a.length - 1);
    }

    Node makeTree(int[] a, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node node = new Node(a[mid]);
        node.left = makeTree(a, start, mid - 1);
        node.right = makeTree(a, mid + 1, end);

        return node;
    }

    /**
     * @param n 검색 시작 노드
     */
    void searchBTree(Node n, int find) {
        if (find < n.data) {
            System.out.println("Data is smaller than " + n.data);
            searchBTree(n.left, find);
        } else if (find > n.data) {
            System.out.println("Data is bigger than " + n.data);
            searchBTree(n.right, find);
        } else {
            System.out.println("Data found!");
        }
    }
}

public class ArrayToBinarySearchTree {
    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        Tree t = new Tree();
//        t.arrayToTree(a);
//        System.out.println(t.search(10));

        t.makeTree(a);
        t.searchBTree(t.root, 2);
    }
}
