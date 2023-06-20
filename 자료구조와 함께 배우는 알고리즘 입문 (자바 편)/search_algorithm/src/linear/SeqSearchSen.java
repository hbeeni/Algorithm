//보초법

package linear;

public class SeqSearchSen {

    //요솟수가 n인 배열 a에서 key와 값이 같은 요소를 보초법으로 선형 검색
    static int seqSearchSen(int[] a, int n, int key) {
        int i = 0;
        a[n] = key;

        while (true) {
            if (a[i] == key) {
                break;
            }
            i++;
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
