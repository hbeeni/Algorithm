// 이진검색(검색 과정을 자세히 출력)

package binary.problem;

public class P4 {

    //--- 배열 a의 앞쪽 n개의 요소에서 key와 일치하는 요소를 이진검색(검색 과정을 자세히 출력)---//
    static int binSearchEx(int[] a, int n, int key) {
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

        int pl = 0;
        int pr = n - 1;

        do {
            int   pc = (pl + pr) / 2;
            System.out.print("   |");

            if (pl != pc) {
                System.out.printf(String.format("%%%ds<-%%%ds+", (pl * 4) + 1, (pc - pl) * 4), "", "");
            } else {
                System.out.printf(String.format("%%%ds<-+", pc * 4 + 1), "");
            }

            if (pc != pr) {
                System.out.printf(String.format("%%%ds->\n", (pr - pc) * 4 - 2), "");
            } else {
                System.out.println("->");
            }
            System.out.printf("%3d|", pc);

            for (int k = 0; k < n; k++) {
                System.out.printf("%4d", a[k]);
            }
            System.out.println("\n   |");

            if (a[pc] == key) {
                return pc;
            } else if (a[pc] < key) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }

        } while (pl <= pr);

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {15, 27, 39, 77, 92, 108, 121};
        int key = 39;
        int idx = binSearchEx(a, a.length, key);

        if (idx == -1) {
            System.out.println("그 값의 요소는 존재하지 않습니다.");
        } else {
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
        }
    }
}
