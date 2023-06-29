package pointer;

import java.util.Comparator;

public class LinkedList<E> {

    //노드
    class Node<E> {

        private E data; //데이터
        private Node<E> next; //뒤쪽 포인터(다음 노드 참조)

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head; //머리 포인터(머리 노드 참조)
    private Node<E> current; //선택 포인터(선택 노드 참조)

    public LinkedList() {
        head = null;
        current = null;
    }

    //검색
    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head;

        while (ptr.next != null) {
            if (c.compare(obj, ptr.data) == 0) {
                current = ptr;
                return ptr.data; //검색 성공
            }

            ptr = ptr.next;
        }

        return null; //검색 실패
    }

    //머리에 노드 삽입
    public void addFirst(E obj) {
        Node<E> ptr = head;
        head = current = new Node<>(obj, ptr);
    }

    //꼬리에 노드 삽입
    public void addLast(E obj) {
        if (head == null) { //리스트가 비어있으면
            addFirst(obj); //머리에 삽입
        } else {
            Node<E> ptr = head;

            while (ptr.next != null) {
                ptr = ptr.next;
            }

            ptr.next = current = new Node<>(obj, null);
        }
    }

    //머리 노드 삭제
    public void removeFirst() {
        if (head != null) {
            head = current = head.next;
        }
    }

    //꼬리 노드 삭제
    public void removeLast() {
        if (head != null) {
            if (head.next == null) {
                removeFirst();
            } else {
                Node<E> ptr = head;

                while (ptr.next != null) {
                    current = ptr;
                    ptr = ptr.next;
                }

                current.next = null;
            }
        }
    }

    //노드 p 삭제
    public void remove(Node p) {
        if (head != null) {
            if (p == head) {
                removeFirst();
            } else {
                Node<E> ptr = head;

                while (ptr.next != p) {
                    ptr = ptr.next;

                    if (ptr == null) {
                        return;
                    }
                }

                ptr.next = p.next;
                current = ptr;
            }
        }
    }

    //선택 노드 삭제
    public void removeCurrentNode() {
        remove(current);
    }

    //모든 노드 삭제
    public void clear() {
        while (head != null) {
            removeFirst();
        }
        current = null;
    }

    //선택 노드를 하나 뒤쪽으로 진행
    public boolean next() {
        if (current == null || current.next == null) {
            return false;
        }
        current = current.next;
        return true;
    }

    //선택 노드 출력
    public void printCurrentNode() {
        if (current == null) {
            System.out.println("선택한 노드가 없습니다.");
        } else {
            System.out.println(current.data);
        }
    }

    //모든 노드 출력
    public void dump() {
        Node<E> ptr = head;

        while (ptr != null) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }
}
