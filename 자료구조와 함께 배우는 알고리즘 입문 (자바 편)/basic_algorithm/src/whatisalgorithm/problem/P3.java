package whatisalgorithm.problem;

import java.util.Scanner;

public class P3 {

    //--- a, b, c, d의 최솟값을 구하여 반환 ---//
    static int min4(int a, int b, int c, int d) {
        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        if (d < min) min = d;

        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        System.out.println(min4(a, b, c, d));
    }
}
