// 배열 요소의 최댓값을 출력합니다(요솟수와 값을 난수로 생성)

package array.problem;

import java.util.Random;

public class P1 {

    //배열의 최댓값을 구하여 반환
    static int maxOf(int[] a) {
        int max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Random rand = new Random();

        System.out.println("키의 최댓값 구하기");
        int num = 1 + rand.nextInt(10); //1 ~ 10

        int[] heights = new int[num];

        System.out.println("키는 아래와 같음");
        for (int i = 0; i < num; i++) {
            heights[i] = 150 + rand.nextInt(40); //150 ~ 189
            System.out.printf("heights[%d]: %d\n", i, heights[i]);
        }

        System.out.println("최댓값: " + maxOf(heights));
    }
}
