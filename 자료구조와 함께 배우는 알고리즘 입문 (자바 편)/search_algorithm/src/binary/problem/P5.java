package binary.problem;

public class P5 {

    static int binSearchX(int[] a, int n, int key) {
        int first = 0;
        int last = n - 1;

        do {
            int middle = (first + last) / 2;

            if (a[middle] == key) {
                //앞으로 스캔
                for (int i = middle - 1; i >= 0; i--) {
                    if (a[i] != key) {
                        return i + 1;
                    }
                }

                /* 책 풀이
                for (; middle > first; middle--) {
                    if (a[middle - 1] < key) {
                        break;
                    }
                }
                return middle;
                */
            } else if (a[middle] < key) {
                first = middle + 1;
            } else {
                last = middle - 1;
            }
        } while (first <= last);

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 7, 7, 7, 8, 8, 9, 9};
        int n = a.length;
        int key = 9;

        int idx = binSearchX(a, n, key);
        if (idx == -1) {
            System.out.println("그 값의 요소는 존재하지 않습니다.");
        } else {
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
        }
    }
}
