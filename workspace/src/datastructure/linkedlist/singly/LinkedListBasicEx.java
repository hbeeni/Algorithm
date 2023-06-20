package datastructure.linkedlist.singly;

public class LinkedListBasicEx {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();
        ll.delete(1); //지울 수 있음
        ll.retrieve();
    }
}