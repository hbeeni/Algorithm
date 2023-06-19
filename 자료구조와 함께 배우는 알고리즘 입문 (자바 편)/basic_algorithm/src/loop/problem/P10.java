package loop.problem;

import java.util.Scanner;

public class P10 {

    static int digitsNoV1(int n) {
        return (n + "").length();
    }

    static int digitsNoV2(int n) {
        int no = 0;

        while (n > 0) {
            no++;
            n /= 10;
        }

        return no;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        while (true) {
            System.out.print("n값: ");
            n = sc.nextInt();

            if (n > 0) {
                break;
            }

            System.out.println("양수를 입력해주세요!");
        }

        System.out.println("그 수는 " + digitsNoV1(n) + "자리입니다.");
        System.out.println("그 수는 " + digitsNoV2(n) + "자리입니다.");
    }
}
