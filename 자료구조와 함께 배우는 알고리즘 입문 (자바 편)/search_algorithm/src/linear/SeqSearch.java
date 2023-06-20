//선형 검색

package linear;

public class SeqSearch {

    //배열 a에서 key와 값이 같은 요소를 선형 검색
    static int seqSearch(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {6, 4, 3, 2, 1, 2, 8};
        int key = 2;

        System.out.printf("%d는 a[%d]에 있습니다.", key, seqSearch(a, key));
    }
}
