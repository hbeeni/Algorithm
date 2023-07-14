package radix;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class B10989_s {

    static int[] a = {215, 15, 344, 372, 294, 100, 8, 145, 24, 198, 831};
    static long result;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int n = Integer.parseInt(br.readLine());
//        a = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            a[i] = Integer.parseInt(br.readLine());
//        }

//        br.close();
        radixSort(5);

        for (int num : a) {
            bw.write(num + "\n");
        }

        bw.flush();
        bw.close();
    }

    /**
     * @param maxSize 최대 자릿수
     */
    static void radixSort(int maxSize) {
        int n = a.length;

        int[] output = new int[n];
        int jarisu = 1;
        int count = 0;

        while (count != maxSize) {
            int[] bucket = new int[10];

            for (int i = 0; i < n; i++) {
                bucket[(a[i] / jarisu) % 10]++;
            }

            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1]; //합 배열을 이용해 index 계산
            }

            for (int i = n - 1; i >= 0; i--) {
                output[bucket[a[i] / jarisu % 10] - 1] = a[i];
                bucket[(a[i] / jarisu) % 10]--;
            }

            for (int i = 0; i < n; i++) {
                a[i] = output[i]; //다음 자릿수를 이동하기 위해 현재 자릿수를 기준 정렬 데이터 저장하기
            }

            jarisu *= 10;
            count++;
        }
    }
}
