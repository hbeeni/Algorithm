// 특정 값을 갖는 배열 안의 모든 요소를 다른 배열에 copy

package linear.problem;

public class P3 {

    //--- 배열 a의 앞쪽 n개의 요소에서 key와 일치하는 모든 요소의 인덱스를  ---//
    //--- 배열 idx의 앞쪽부터 순서대로 저장하고 일치하는 요솟수를 반환합니다 ---//
    static int searchIdx(int[] a, int n, int key, int[] idx) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == key) {
                idx[count++] = i;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a = {1, 9, 2, 9, 4, 6, 7, 9};
        int n = a.length;
        int key = 9;
        int[] idx = new int[n];

        int count = searchIdx(a, n, key, idx);
        System.out.println("count = " + count);
        for (int i = 0; i < count; i++) {
            System.out.println("그 값은 " + "x[" + idx[i] + "]에 있습니다.");
        }
    }
}
