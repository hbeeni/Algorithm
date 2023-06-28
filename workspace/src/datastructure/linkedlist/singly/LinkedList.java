package datastructure.linkedlist.singly;

public class LinkedList {

    private Node header;

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

    Node getHeader() {
        return header;
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
    static Node kthToLast(Node n, int k) {
        Node first = n;
        int size = 0;

        while (n.next != null) {
            size++;
            n = n.next;
        }

        n = first;
        for (int i = 0; i < size - k + 1; i++) {
            n = n.next;
        }

        return n;
    }

    //끝에서 k번째 노드 찾기 - 재귀호출
    //끝까지 들어갔다가 나올 때 세면서 나옴
    static int kthToLastRecurV1(Node n, int k) {
        if (n == null) { //마지막 노드의 다음 노드이면
            return 0;
        }

        int count = kthToLastRecurV1(n.next, k) + 1;
        if (count == k) {
            System.out.println("data=" + n.data);
        }

        return count;
    }

    //끝에서 k번째 노드 찾기 - 재귀호출
    //Node 반환
    static Node kthToLastRecurV2(Node n, int k, Reference r) {
        if (n == null) { //마지막 노드의 다음 노드이면
            return null;
        }

        Node found = kthToLastRecurV2(n.next, k, r);

        if (++r.count == k) {
            return n;
        }

        return found;
    }

    //끝에서 k번째 노드 찾기 - 포인터 2개 사용
    static Node kthToLastPointer(Node n, int k) {
        Node p1 = n;
        Node p2 = n;

        for (int i = 0; i < k; i++) {
            if (p2.next != null) {
                p2 = p2.next;
            }
        }

        while (p2 != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}
