package datastructure.linkedlist.singly;

public class LinkedList {

    Node header;

    static class Node {
        int data;
        Node next = null;

        @Override
        public String toString() {
            return "data=" + data;
        }
    }

    public LinkedList() {
        header = new Node();
    }

    void append(int data) {
        Node end = new Node();
        end.data = data;
        Node n = header;

        while (n.next != null) {
            n = n.next;
        }

        n.next = end;
    }

    void delete(int data) {
        Node n = header;

        while (n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
                break;
            } else {
                n = n.next;
            }
        }
    }

    void retrieve() {
        Node n = header.next;

        while (n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }

        System.out.println(n.data);
    }

    //중복 제거
    void removeDups() {
        Node n = header;

        while (n != null && n.next != null) {
            Node r = n;

            while (r.next != null) {
                if (n.data == r.next.data) {
                    r.next = r.next.next;
                } else {
                    r = r.next;
                }
            }

            n = n.next;
        }
    }

    //끝에서 k번째 노드 찾기
    Node kthToLastV1(int k) {
        Node n = header;
        int size = 0;

        while (n.next != null) {
            size++;
            n = n.next;
        }

        n = header;
        for (int i = 0; i < size - k + 1; i++) {
            n = n.next;
        }

        return n;
    }

    //끝에서 k번째 노드 찾기 - 재귀호출
    Node kthToLastV2(Node n, int k) {
        return null;
    }
}
