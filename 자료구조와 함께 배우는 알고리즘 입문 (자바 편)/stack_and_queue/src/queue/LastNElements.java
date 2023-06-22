package queue;

import java.util.Scanner;

public class LastNElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = 3;
        int[] a = new int[N];
        int cnt = 0; //입력받은 개수
        int retry; //다시 한 번?

        System.out.println("정수를 입력하세요.");
        do {
            System.out.printf("%d번째 정수: ", cnt + 1);
            a[cnt % N] = sc.nextInt();
            cnt++;

            System.out.print("계속 할까요? (예.1/아니오.0): ");
            retry = sc.nextInt();
        } while (retry == 1);

        //출력
        int index = cnt % N;
        for (int i = 0; i < N; i++) {
            System.out.printf("%d번째 = %d\n", cnt - N + 1 + i, a[index % N]);
            index++;
        }

        /* 책
        int i = cnt - N;
        if (i < 0) i = 0;

        for ( ; i < cnt; i++) {
            System.out.printf("%2d번째 ＝ %d\n", i + 1, a[i % N]);
        }
        */
    }
}
