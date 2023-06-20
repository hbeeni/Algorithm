//단방향 LinkedList의 끝에서 k번째 노드를 찾는 알고리즘을 구현하시오

package datastructure.linkedlist.singly;

public class KthToLastEx {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(3);
        ll.append(2);
        ll.append(1);
        ll.append(4);
        ll.retrieve();
        System.out.println(ll.kthToLastV1(1));
    }
}
