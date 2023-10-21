package algorithmcodingtest.sorting.bubble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1377_s {

    static class Data implements Comparable<Data> {
        int index;
        int value;

        public Data(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Data o) { //value 기준 오름차순 정렬
            return value - o.value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Data[] a = new Data[n];

        for (int i = 0; i < n; i++) {
            a[i] = new Data(i, Integer.parseInt(br.readLine()));
        }

        /**
         * 버블소트에서 for 한 번 돌 때마다 왼쪽으로 최대 1칸만 이동할 수 있음
         * -> 왼쪽으로 가장 많이 이동한 index 값이 for문 돈 횟수
         * ->  + 1: 정렬 완료됐을 때 마지막으로 도는 for문
         */
        Arrays.sort(a);
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (max < a[i].index - i) { //정렬 전 index - 현재 index
                max = a[i].index - i;
            }
        }

        System.out.println(max + 1);
    }
}
