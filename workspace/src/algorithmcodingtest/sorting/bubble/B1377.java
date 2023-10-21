package algorithmcodingtest.sorting.bubble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(1);
        } else { //돌면서 자동으로 정렬되는 경우의 수도 생각해야 하는데 못함 ex) 4 2 1 5 3
            int count = 1;
            int min = a[n - 1];

            for (int i = n - 2; i >= 0; i--) {
                if (a[i] > min) {
                    count++;
                } else {
                    min = a[i];
                }
            }

            System.out.println(count);
        }
    }
}
