package insertion.problem;

public class P8 {

    static void insertionSortSen(int[] a, int n) {
        for (int i = 2; i < n; i++) {
            int tmp = a[0] = a[i];
            int j = i;

            for ( ; a[j - 1] > tmp; j--) {
                a[j] = a[j - 1];
            }

            if (j > 0) {
                a[j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 7, 6, 4, 3, 7, 1, 9, 8};
        insertionSortSen(a, a.length);

        for (int i = 1; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
