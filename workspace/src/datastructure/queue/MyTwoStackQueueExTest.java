/**
 * 두 개의 Stack으로 하나의 Queue를 구현하시오.
 */

package datastructure.queue;

public class MyTwoStackQueueExTest {
    public static void main(String[] args) {
        MyTwoStackQueueEx<Integer> tq = new MyTwoStackQueueEx<>();
        tq.add(1);
        tq.add(2);
        tq.add(3);
        System.out.println(tq.remove());
        System.out.println(tq.remove());
        System.out.println(tq.peek());
        System.out.println(tq.remove());
    }
}
