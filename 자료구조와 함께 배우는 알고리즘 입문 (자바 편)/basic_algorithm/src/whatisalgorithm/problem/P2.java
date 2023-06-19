package whatisalgorithm.problem;

import java.util.Scanner;

public class P2 {

    //--- a, b, c의 최솟값을 구하여 반환 ---//
    static int min3(int a, int b, int c) {
        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;

        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(min3(a, b, c));
    }
}
