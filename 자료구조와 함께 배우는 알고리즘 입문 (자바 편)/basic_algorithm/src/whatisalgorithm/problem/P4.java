package whatisalgorithm.problem;

import java.util.Arrays;
import java.util.Scanner;

public class P4 {

    static int med3(int a, int b, int c) {
        int[] arr = {a, b, c};
        Arrays.sort(arr);

        return arr[1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(med3(a, b, c));
    }
}
