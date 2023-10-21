//메모리 초과

package algorithmcodingtest.search.dfs;

import java.util.Arrays;
import java.util.Scanner;

public class B2023 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        boolean[] prime = new boolean[(int) (Math.pow(10, n)) + 1];
        Arrays.fill(prime, true);

        //에라스토테네스 체 알고리즘
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i < Math.sqrt(prime.length); i++) {
            //i의 제곱수부터 검사하므로 i는 전체 범위의 제곱근까지 검사
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = false;
            }
        }

        for (int i = (int) (Math.pow(10, n - 1)); i < Math.pow(10, n); i++) {
            int num = i;

            while (prime[num] && num > 0) {
                num /= 10;
            }

            if (num == 0) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
