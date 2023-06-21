package binary;

public class BinSearch {

    static int binSearch(int[] a, int n, int key) {
        int pl = 0; //검색 범위의 첫 인덱스
        int pr = n - 1; //검색 범위의 첫 인덱스

        do {
            int pc = (pl + pr) / 2; //중앙 요소 인덱스

            if (a[pc] == key) {
                return pc;
            } else if (a[pc] < key) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        } while (pl <= pr);

        return -1; //검색 실패
    }

    public static void main(String[] args) {
        int[] a = {15, 27, 39, 77, 92, 108, 121};
        int key = 39;
        System.out.printf("%d값은 a[%d]에 있습니다.", key, binSearch(a, a.length, key));
    }
}
