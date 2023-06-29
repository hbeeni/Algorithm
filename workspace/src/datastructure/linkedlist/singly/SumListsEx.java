/**
 * 어떤 숫자를 자리수별로 한개씩 Linked List에 담았다.
 * 그런데 1의 자리가 헤더에 오도록 거꾸로 담았다.
 * 이런 식의 Linked List 두개를 받아서 합산하고,
 * 같은 식으로 Linked List에 담아서 반환하라
 *
 * ex)
 * 9 -> 1 -> 4: 419
 * 6 -> 4 -> 3: 346
 * 419 + 346 = 765
 * 결과: 5 -> 6 -> 7
 */

package datastructure.linkedlist.singly;

public class SumListsEx {
    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();

        ll1.append(1);
        ll1.retrieve();

        ll2.append(9);
        ll2.retrieve();

        System.out.println("[V1]");
        LinkedList result = sumListsV1(ll1, ll2);
        result.retrieve();

        System.out.println("\n[V2]");
        Node n = sumListsV2(ll1.get(1), ll2.get(1), 0);
        while (n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }

    //me
    private static LinkedList sumListsV1(LinkedList ll1, LinkedList ll2) {
        Node n1 = ll1.getHeader();
        Node n2 = ll2.getHeader();
        int sum = 0;
        int digit = 1;

        while (n1.next != null) {
            sum += n1.next.data * digit;
            digit *= 10;
            n1 = n1.next;
        }

        digit = 1;
        while (n2.next != null) {
            sum += n2.next.data * digit;
            digit *= 10;
            n2 = n2.next;
        }

        LinkedList result = new LinkedList();
        while (sum > 0) {
            result.append(sum % 10);
            sum /= 10;
        }

        return result;
    }

    private static Node sumListsV2(Node l1, Node l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        Node result = new Node();
        int value = carry; //합산한 결과 저장

        if (l1 != null) {
            value += l1.data;
        }
        if (l2 != null) {
            value += l2.data;
        }

        result.data = value % 10;

        if (l1 != null || l2 != null) {
            result.next = sumListsV2(l1 == null ? null : l1.next,
                    l2 == null ? null : l2.next,
                    value / 10);
        }

        return result;
    }
}
