// 단순교환정렬(버전 3 : 교환 과정을 자세히 출력) 풀이

package bubble.problem;

public class P4 {

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

        int i = 0;
        int k = 0;                            // a[k]보다 앞쪽은 정렬을 마친 상태
        while (k < n - 1) {
            System.out.printf("패스%d : \n", ++i);
            int last = n - 1;            // 마지막으로 요소를 교환한 위치
            for (int j = n - 1; j > k; j--) {
                for (int m = 0; m < n - 1; m++)
                    System.out.printf("%3d %c", a[m], (m != j - 1) ? ' ' :
                            (a[j - 1] > a[j]) ? '+' : '-');
                System.out.printf("%3d\n", a[n - 1]);
                ccnt++;
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    last = j;
                    scnt++;
                }
            }
            k = last;
        }
        System.out.println("비교를 " + ccnt + "회 했습니다.");
        System.out.println("교환을 " + scnt + "회 했습니다.");
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 9, 4, 7, 8, 6};
        int n = a.length;

        bubbleSort(a, n);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < n; i++)
            System.out.println("a[" + i + "]=" + a[i]);
    }
}
