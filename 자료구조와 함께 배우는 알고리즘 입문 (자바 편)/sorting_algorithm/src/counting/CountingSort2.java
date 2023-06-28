/**
 * 바로 입출력 하는 경우
 */

package counting;

public class CountingSort2 {
    public static void main(String[] args) {
        int max = 30;

        int[] counting = new int[max + 1]; //수의 범위: 0 ~ 30

        for (int i = 0; i < 50; i++) { //수열의 크기: 50
            counting[(int) (Math.random() * (max + 1))]++;
        }

        for (int i = 0; i < counting.length; i++) {
            while (counting[i]-- > 0) {
                System.out.print(i + " ");
            }
        }
    }
}
