/**
 * Linked List에 있는 노드들을 x값을 기준으로
 * 값이 작은 것들은 왼쪽, 큰 것들은 오른쪽 두 파트로 나누시오.
 * (단, x는 오른쪽 파트 어디에 놔도 상관없음)
 */

package datastructure.linkedlist.singly;

public class PartitionEx {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(8);
        ll.append(5);
        ll.append(2);
        ll.append(7);
        ll.append(3);
        ll.append(4);
        ll.retrieve();

        /*ll = partition(ll, 5);
        ll.retrieve();*/

        Node n = partitionV2(ll.get(1), 5);
        while (n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }

    //두 개의 LinkedList 사용(내가 작성)
    static LinkedList partition(LinkedList ll, int x) {
        LinkedList small = new LinkedList(); //x보다 작은 값을 저장
        LinkedList large = new LinkedList(); //x보다 크거나 같은 값을 저장
        int lastIdx = 0; //small의 마지막 인덱스

        Node n = ll.getHeader();

        while (n.next != null) {
            int data = n.next.data;

            if (data < x) {
                small.append(data);
                lastIdx++;
            } else {
                large.append(data);
            }

            n = n.next;
        }

        //small의 마지막 노드의 다음 노드에 large의 첫 번째 노드를 넣어줌
        small.get(lastIdx).next = large.get(1);
        return small;
    }

    //두 줄로 세우기: 포인터 4개 사용
    static Node partitionV1(Node n, int x) {
        Node s1 = null; //작은 쪽 시작 노드 (첫번째 줄)
        Node e1 = null; //작은 쪽 끝 노드
        Node s2 = null; //큰 쪽 시작 노드 (두번째 줄)
        Node e2 = null; //큰 쪽 끝 노드

        while (n != null) {
            Node next = n.next;
            n.next = null;

            if (n.data < x) {
                if (s1 == null) {
                    s1 = n;
                    e1 = s1;
                } else {
                    e1.next = n;
                    e1 = n;
                }
            } else {
                if (s2 == null) {
                    s2 = n;
                    e2 = s2;
                } else {
                    e2.next = n;
                    e2 = n;
                }
            }

            n = next;
        }

        if (s1 == null) {
            return s2;
        }

        e1.next = s2;
        return s1;
    }

    //앞뒤로 붙이기: 포인터 2개 사용
    static Node partitionV2(Node n, int x) {
        Node head = n;
        Node tail = n;

        while (n != null) {
            Node next = n.next;

            if (n.data < x) { //작으면 head의 앞에 붙이기 -> 앞부분은 역순이 됨
                n.next = head;
                head = n;
            } else { //크면 tail의 뒤에 붙이기
                tail.next = n;
                tail = n;
            }

            n = next;
        }

        tail.next = null;
        return head;
    }
}
