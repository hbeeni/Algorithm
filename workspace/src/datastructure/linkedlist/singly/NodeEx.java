package datastructure.linkedlist.singly;

public class NodeEx {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.retrieve();
        head.delete(1); //지울 수 없음
        head.delete(2);
        head.delete(3);
        head.retrieve();
    }
}
