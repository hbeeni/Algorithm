// 단순교환정렬(버전 2 : 교환 과정을 자세히 출력)

package bubble.problem;

class P3 {

    //--- 배열의 요소 a[idx1]과 a[idx2]를 교환 ---//
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    //--- 단순교환정렬 ---//
    static void bubbleSort(int[] a, int n) {
        int ccnt = 0;            // 비교 회수
        int scnt = 0;            // 교환 회수

        for (int i = 0; i < n - 1; i++) {
            int exchg = 0;                                // 패스에 의한 교환 회수
            System.out.printf("패스%d : \n", i + 1);

            for (int j = n - 1; j > i; j--) {
                for (int m = 0; m < n - 1; m++)
                    System.out.printf("%3d %c", a[m], (m != j - 1) ? ' ' :
                            (a[j - 1] > a[j]) ? '+' : '-');
                System.out.printf("%3d\n", a[n - 1]);

                ccnt++;
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    exchg++;
                    scnt++;
                }
            }
            for (int m = 0; m < n; m++)
                System.out.printf("%3d  ", a[m]);
            System.out.println();
            if (exchg == 0) break;                    // 교환이 이루어지지 않으므로 멈춤
        }
        System.out.println("비교를 " + ccnt + "회 했습니다.");
        System.out.println("교환을 " + scnt + "회 했습니다.");
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 9, 4, 7, 8, 6};
        int n = a.length;

        bubbleSort(a, n);

        System.out.println("오름차순으로 정렬하였습니다.");
        for (int i = 0; i < n; i++)
            System.out.println("a[" + i + "]＝" + a[i]);
    }
}

