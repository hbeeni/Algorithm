//https://yunmap.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Java%EB%A1%9C-%EA%B5%AC%ED%98%84%ED%95%98%EB%8A%94-%EC%89%AC%EC%9A%B4-Merge-Sort-%EB%B3%91%ED%95%A9-%EC%A0%95%EB%A0%AC-%ED%95%A9%EB%B3%91-%EC%A0%95%EB%A0%AC

package merge;

import java.io.*;

public class B2751 {

    static int[] a;
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        a = new int[n];
        tmp = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, n - 1);

        for (int i : a) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void mergeSort(int start, int end) {
        if (start >= end) {
            return;
        }

        int m = start + (end - start) / 2;

        mergeSort(start, m);
        mergeSort(m + 1, end);

        for (int i = start; i <= end; i++) {
            tmp[i] = a[i];
        }

        int k = start;
        int index1 = start;
        int index2 = m + 1;

        //두 그룹을 병합
        while (index1 <= m && index2 <= end) {
            //index1과 index2의 값을 비교해서 더 작은 수를 선택해 배열에 저장
            if (tmp[index1] > tmp[index2]) {
                a[k++] = tmp[index2];
                index2++;
            } else {
                a[k++] = tmp[index1];
                index1++;
            }
        }

        //한쪽 그룹이 모두 선택된 후 남아 있는 값 정리
        while (index1 <= m) {
            a[k++] = tmp[index1++];
        }
        while (index2 <= m) {
            a[k++] = tmp[index2++];
        }
    }
}
