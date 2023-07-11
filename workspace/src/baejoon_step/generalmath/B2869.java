//https://st-lab.tistory.com/75
//https://velog.io/@lifeisbeautiful/Java-%EB%B0%B1%EC%A4%80-2869%EB%B2%88-%EB%8B%AC%ED%8C%BD%EC%9D%B4%EB%8A%94-%EC%98%AC%EB%9D%BC%EA%B0%80%EA%B3%A0-%EC%8B%B6%EB%8B%A4-%EC%9E%90%EB%B0%94

package baejoon_step.generalmath;

import java.util.Scanner;

public class B2869 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();

        int destination = v - b;
        int day = destination / (a - b) +
                (destination % (a - b) == 0 ? 0 : 1);

        System.out.println(day);
    }
}