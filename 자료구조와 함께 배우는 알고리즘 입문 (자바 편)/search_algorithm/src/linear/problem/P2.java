// 선형검색(검색 과정을 자세히 출력)

package linear.problem;

public class P2 {

    //--- 배열 a의 앞쪽 n개의 요소에서 key와 일치하는 요소를 선형검색(보초법)---//
    static int seqSearchEx(int[] a, int n, int key) {
        System.out.print("   |");
        for (int k = 0; k < n; k++) {
            System.out.printf("%4d", k);
        }
        System.out.println();

        System.out.print("---+");
        for (int k = 0; k < 4 * n + 2; k++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print("   |");
            System.out.printf(String.format("%%%ds*\n", (i * 4) + 3), "");
            System.out.printf("%3d|", i);

            for (int k = 0; k < n; k++) {
                System.out.printf("%4d", a[k]);
            }
            System.out.println("\n   |");

            if (a[i] == key) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int num = 7;
        int[] a = {6, 4, 3, 2, 1, 2, 8, 0};
        int key = 2;

        int idx = seqSearchEx(a, num, key);	// 배열 x에서 값이 ky인 요소를 검색

        if (idx == -1) {
            System.out.println("그 값의 요소는 존재하지 않습니다.");
        } else {
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
        }
    }
}
