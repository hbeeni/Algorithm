/**
 * 정렬되어 있지 않은 LinkedList의 중복되는 값 제거
 * (단, 별도의 버퍼 사용 금지)
 * (3 -> 2 -> 1 -> 2 -> 4)
 */

package datastructure.linkedlist;

public class RemoveDuplicates {
    public static void main(String[] args) {
        LinkedListV2 ll = new LinkedListV2();
        ll.append(2);
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(3);
        ll.append(2);
        ll.append(2);
        ll.retrieve();
        ll.removeDups();
        ll.retrieve();
    }
}

class LinkedListV2 {
    Node header;

    static class Node {
        int data;
        Node next = null;
    }

    public LinkedListV2() {
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
}