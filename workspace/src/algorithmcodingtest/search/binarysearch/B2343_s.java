//Do it! 코딩 테스트 - 자바 편 189p

package algorithmcodingtest.search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2343_s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int start = 0, end = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());

            a[i] = input;
            start = Math.max(input, start); //start = 가장 긴 강의 길이
            end += input; //end = 모든 강의 길이 합
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0, count = 0;

            //mid 값으로 모든 강의를 저장할 수 있는지 확인
            for (int i = 0; i < n; i++) {
                if (sum + a[i] > mid) {
                    count++;
                    sum = 0;
                }

                sum += a[i];
            }

//            if (sum != 0) { //탐색 후 sum이 0이 아니면 블루레이 1개 더 필요 -> 마지막에 a[i] 더하고 for문 나오는데 sum이 0이 아닐 수 있나..?
//                count++;
//            }
            count++; //count 되지 않은 마지막 블루레이

            if (count > m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }
}
