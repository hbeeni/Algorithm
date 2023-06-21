// 선형검색(보초법 : for문을 사용하여 구현)

package linear.problem;

public class P1 {

    //요솟수가 n인 배열 a에서 key와 값이 같은 요소를 보초법으로 선형 검색
    static int seqSearchSen(int[] a, int n, int key) {
        int i;
        a[n] = key;

        for (i = 0; a[i] != key; i++) {
            ;
        }

        return i == n ? -1 : i;
    }

    public static void main(String[] args) {
        int num = 7;
        int[] a = {6, 4, 3, 2, 1, 2, 8, 0};
        int key = 2;

        System.out.printf("%d는 a[%d]에 있습니다.", key, seqSearchSen(a, num, key));
    }
}
