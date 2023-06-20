/**
 * 정렬되어 있지 않은 LinkedList의 중복되는 값 제거
 * (단, 별도의 버퍼 사용 금지)
 * (3 -> 2 -> 1 -> 2 -> 4)
 */

package datastructure.linkedlist.singly;

public class RemoveDuplicatesEx {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
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