/**
 * 두 개의 Stack으로 하나의 Queue를 구현하시오.
 */

package datastructure.queue;

public class TwoStackQueueExTest {
    public static void main(String[] args) {
        TwoStackQueueEx<Integer> tq = new TwoStackQueueEx<>();
        tq.add(1);
        tq.add(2);
        tq.add(3);
        tq.add(4);
        System.out.println(tq.remove());
        System.out.println(tq.remove());
        System.out.println(tq.peek());
        System.out.println(tq.remove());
        System.out.println(tq.isEmpty());
        System.out.println(tq.remove());
        System.out.println(tq.isEmpty());
    }
}
