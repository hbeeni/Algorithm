/**
 * Linked List 안에 루프가 있는지 확인하고,
 * 루프가 시작되는 노드를 찾으시오.
 *
 * ex)
 *              4 -> 5
 *            ↗        ↘
 * 1 -> 2 -> 3          6
 *            ↖        ↙
 *              8 <- 7
 */

package datastructure.linkedlist.singly;

public class FindLoopEx {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(5);
        ll.append(6);
        ll.append(7);
        ll.append(8);
        ll.get(8).next = ll.get(3);
        System.out.println(findLoop(ll.get(1)));
    }

    private static Node findLoop(Node first) {
        Node fast = first;
        Node slow = first;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = first;

        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
