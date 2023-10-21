package algorithmcodingtest.datastructure.twopointer;

import java.util.Scanner;

public class B2018_s {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1;

        int s = 1;
        int e = 1;
        int sum = 1;

        while (e != n) {
            if (sum == n) {
                count++;
                e++;
                sum += e;
            } else if (sum > n) {
                sum -= s;
                s++;
            } else {
                e++;
                sum += e;
            }
        }

        System.out.println(count);
    }
}
