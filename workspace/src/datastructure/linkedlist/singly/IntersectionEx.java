/**
 * 주어진 두 개의 단방향 Linked List에서 교차되는 노드를 찾으시오.
 * (단, 교차점은 값이 아닌 주소로 찾아야 함)
 *
 * ex)
 * 5 -> 7 -> 9 -> 10 -> 7 -> 6
 *      6 -> 8 ↗
 * 교차되는 노드: 10
 */

package datastructure.linkedlist.singly;

public class IntersectionEx {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.append(5);
        l1.append(7);
        l1.append(9);
        l1.append(10);
        l1.append(7);
        l1.append(6);
        l1.retrieve();

        LinkedList l2 = new LinkedList();
        l2.append(6);
        l2.append(8);
        l2.get(2).next = l1.get(4);
        l2.retrieve();

        Node n = getIntersectionV2(l1.get(1), l2.get(2));

        if (n == null) {
            System.out.println("NOT FOUND");
        } else {
            System.out.println("INTERSECTION = " + n.data);

            while (n.next != null) {
                System.out.print(n.data + " -> ");
                n = n.next;
            }
            System.out.println(n.data);
        }
    }

    private static Node getIntersectionV1(Node n1, Node n2) {
        Node head2 = n2;

        while (n1.next != null) {
            while (n2.next != null) {
                if (n1.next == n2.next) {
                    return n1.next;
                }

                n2 = n2.next;
            }

            n1 = n1.next;
            n2 = head2;
        }

        return null;
    }

    private static Node getIntersectionV2(Node l1, Node l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        int len1 = getListLength(l1);
        int len2 = getListLength(l2);

        if (len1 < len2) {
            l2 = getStartNode(l2, len2 - len1);
        } else if (len1 > len2){
            l1 = getStartNode(l1, len1 - len2);
        }

        while (l1.next != l2.next) {
            l1 = l1.next;
            l2 = l2.next;
        }

        return l1.next;
    }

    private static Node getStartNode(Node node, int start) {
        for (int i = 0; i < start; i++) {
            node = node.next;
        }

        return node;
    }

    private static int getListLength(Node l) {
        int total = 0;

        while (l != null) {
            total++;
            l = l.next;
        }

        return total;
    }
}
