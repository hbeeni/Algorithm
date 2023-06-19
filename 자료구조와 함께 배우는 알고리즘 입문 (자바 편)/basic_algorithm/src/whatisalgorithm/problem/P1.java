package whatisalgorithm.problem;

import java.util.Scanner;

public class P1 {

    //--- a, b, c, d의 최댓값을 구하여 반환 ---//
    static int max4(int a, int b, int c, int d) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        if (d > max) max = d;

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        System.out.println(max4(a, b, c, d));
    }
}
