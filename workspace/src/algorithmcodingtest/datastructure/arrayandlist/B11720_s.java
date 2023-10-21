package algorithmcodingtest.datastructure.arrayandlist;

import java.util.Scanner;

public class B11720_s {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();

        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += cNum[i] - '0';
        }

        System.out.println(sum);
    }
}
