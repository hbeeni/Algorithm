/**
 * [단방향 Linked List 중간 노드 삭제]
 * 단방향 Linked List에서 중간에 있는 노드를 삭제하시오.
 * (단, 당신은 첫번째 노드가 어딨는지 모르고, 오직 삭제할 노드만 갖고 있다.)
 */

package datastructure.linkedlist.singly;

public class DeleteNodeEx {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();

        deleteNode(ll.get(2));
        ll.retrieve();
    }

    private static boolean deleteNode(Node n) {
        if (n == null || n.next == null) {
            return false;
        }

        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }
}
