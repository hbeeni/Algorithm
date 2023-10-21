package algorithmcodingtest.sorting.quick;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11004_s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(a, 0, n - 1, k - 1);
        System.out.println(a[k - 1]);
    }

    private static void quickSort(int[] a, int start, int end, int k) {
        if (start < end) {
            int pivotIdx = partition(a, start, end);

            if (pivotIdx == k) {
                return;
            } else if (k < pivotIdx) {
                quickSort(a, start, pivotIdx - 1, k);
            } else {
                quickSort(a, pivotIdx + 1, end, k);
            }
        }
    }

    private static int partition(int[] a, int start, int end) {
        if (start + 1 == end) { //원소가 2개일 때
            if (a[start] > a[end]) {
                swap(a, start, end);
            }
            return end;
        }

        int mid = (start + end) / 2;
        swap(a, start, mid);

        int pivot = a[start];
        int i = start + 1, j = end;

        while (i <= j) {
            while (pivot > a[i] && i < a.length - 1) {
                i++;
            }
            while (pivot < a[j] && j > 0) {
                j--;
            }
            if (i <= j) {
                swap(a, i++, j--);
            }
        }

        a[start] = a[j];
        a[j] = pivot;
        return j;
    }

    private static void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }
}
