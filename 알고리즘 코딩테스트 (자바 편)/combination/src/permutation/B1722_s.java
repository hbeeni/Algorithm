//어려움

package permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1722_s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] factorials = new long[n + 1];
        int[] sequence = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        //팩토리얼 초기화: 각 자릿수에서 만들 수 있는 경우의 수
        factorials[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorials[i] = factorials[i - 1] * i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        if ("1".equals(st.nextToken())) {
            long k = Long.parseLong(st.nextToken());
            for (int i = 1; i <= n; i++) {
                for (int j = 1, count = 1; j <= n; j++) {
                    if (visited[j]) {
                        continue; //이미 사용한 숫자는 사용할 수 없음
                    }
                    //주어진 k에 따라 각 자리에 들어갈 수 있는 수 찾기
                    if (k <= count * factorials[n - i]) {
                        k -= (count - 1) * factorials[n - i];
                        sequence[i] = j;
                        visited[j] = true;
                        break;
                    }
                    count++;
                }
            }
            for (int i = 1; i <= n; i++) {
                System.out.print(sequence[i] + " ");
            }
        } else {
            long k = 1;
            for (int i = 1; i <= n; i++) {
                sequence[i] = Integer.parseInt(st.nextToken());
                long count = 0;
                for (int j = 1; j < sequence[i]; j++) {
                    if (!visited[j]) {
                        count++; //미사용 숫자 개수만큼 카운트
                    }
                }
                k += count * factorials[n - i]; //자릿수에 따라서 순서 더하기
                visited[sequence[i]] = true;
            }
            System.out.println(k);
        }
    }
}
