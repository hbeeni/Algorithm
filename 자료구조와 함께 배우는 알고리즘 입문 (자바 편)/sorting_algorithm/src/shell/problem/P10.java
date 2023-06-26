//버전 1과 2의 요소 이동 횟수를 카운트해서 비교

package shell.problem;

public class P10 {

    private static int shellSortV1(int[] a, int n) {
        int count = 0;

        for (int h = n / 2; h > 0; h /= 2) {
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];

                for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    a[j + h] = a[j];
                    count++;
                }

                a[j + h] = tmp;
                count++;
            }
        }

        return count;
    }

    private static int shellSortV2(int[] a, int n) {
        int count = 0;
        int h;
        for (h = 1; h < n; h = 3 * h + 1) {}

        for (; h > 0; h /= 3) {
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];

                for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    a[j + h] = a[j];
                    count++;
                }

                a[j + h] = tmp;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a = {7, 6, 4, 3, 7, 1, 9, 8};
        int count1 = shellSortV1(a, a.length);
        int count2 = shellSortV2(a, a.length);
        System.out.println("count1 = " + count1);
        System.out.println("count2 = " + count2);
    }
}
