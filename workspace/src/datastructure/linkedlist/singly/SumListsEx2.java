/**
 * Linked List의 숫자가 거꾸로가 아니면?
 *
 * ex)
 * 4 -> 1 -> 9: 419
 * 3 -> 4: 34
 * 419 + 34 = 453
 * 결과: 4 -> 5 -> 3
 */

package datastructure.linkedlist.singly;

public class SumListsEx2 {
    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();

        ll1.append(9);
        ll1.append(9);
        ll1.retrieve();

        ll2.append(1);
        ll2.retrieve();

        Node n = sumLists(ll1.get(1), ll2.get(1));
        while (n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }

    private static Node sumLists(Node l1, Node l2) {
        int len1 = getListLength(l1);
        int len2 = getListLength(l2);

        if (len1 < len2) {
            l1 = LPadList(l1, len2 - len1);
        } else {
            l2 = LPadList(l2, len1 - len2);
        }

        Storage storage = addLists(l1, l2);
        if (storage.carry == 0) {
            return storage.result;
        }

        return insertBefore(storage.result, storage.carry);
    }

    //Storage에 Node와 carry를 넣어서 반환
    private static Storage addLists(Node l1, Node l2) {
        if (l1 == null && l2 == null) {
            return new Storage();
        }

        Storage storage = addLists(l1.next, l2.next);

        int value = storage.carry + l1.data + l2.data;
        int data = value % 10;

        storage.result = insertBefore(storage.result, data);
        storage.carry = value / 10;

        return storage;
    }

    private static int getListLength(Node l) {
        int total = 0;

        while (l != null) {
            total++;
            l = l.next;
        }

        return total;
    }

    /**
     *
     * @param node 현재 Node
     * @param data 앞에 붙일 Node의 data
     * @return 앞에 붙인 Node
     */
    private static Node insertBefore(Node node, int data) {
        Node before = new Node(data);
        before.next = node;
        return before;
    }

    /**
     * 왼쪽에 0 채우기
     * @param length 0을 채워야 하는 길이
     */
    private static Node LPadList(Node l, int length) {
        Node head = l;

        for (int i = 0; i < length; i++) {
            Node before = insertBefore(head, 0);
            head = before;
        }

        return head;
    }
}
