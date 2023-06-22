package queue.problem;

import java.util.Scanner;

public class IntArrayQueueTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntArrayQueue s = new IntArrayQueue(5);

        while (true) {
            System.out.println("\n현재 데이터 개수 : " + s.size() + " / "
                    + s.capacity());
            System.out.print("(1) 인큐　(2) 디큐　(3) 피크　" +
                    "(4) 덤프　(0) 종료 : ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x = 0;
            switch (menu) {
                case 1: //  인큐
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    try {
                        s.enque(x);
                    } catch (IntArrayQueue.OverflowIntArrayQueueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                case 2: //  디큐
                    try {
                        x = s.deque();
                        System.out.println(" 디큐한 데이터는 " + x + "입니다.");
                    } catch (IntArrayQueue.EmptyIntArrayQueueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 3: // 피크
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntArrayQueue.EmptyIntArrayQueueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 4: // 덤프
                    s.dump();
                    break;
            }
        }
    }
}
