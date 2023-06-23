/**
 * 메서드 recur3의 비재귀적 구현
 * static void recur3(int n) {
 *     if (n > 0) {
 *         recur3(n - 1);
 *         recur3(n - 3);
 *         System.out.print(n);
 *     }
 * }
  */

package analysis.problem;

public class P6 {

    static void recur3(int n) {
        int[] nstk = new int[100];
        int[] sstk = new int[100];
        int ptr = -1;
        int sw = 0;

        while (true) {
            if (n > 0) {
                ptr++;
                nstk[ptr] = n;
                sstk[ptr] = sw;

                if (sw == 0) {
                    n -= 1;
                } else if (sw == 1) {
                    n -= 2;
                    sw = 0;
                }

                continue;
            }

            do {
                n = nstk[ptr];
                sw = sstk[ptr--] + 1;

                if (sw == 2) {
                    System.out.print(n);
                    if (ptr < 0) {
                        return;
                    }
                }
            } while (sw == 2);
        }
    }

    public static void main(String[] args) {
        recur3(4);
    }
}
