//https://st-lab.tistory.com/73

package baejoon_step.generalmath;

import java.util.Scanner;

public class B2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 1) {
            System.out.println(1);
        } else {
            int count = 1;
            int max = 1;

            while (n > max) {
                max += 6 * count;
                count++;
            }

            System.out.println(count);
        }
    }
}
