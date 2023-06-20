//1000이하의 소수 나열 (버전 1)

package array;

public class PrimeNumber1 {
    public static void main(String[] args) {
        int counter = 0; //나눗셈 횟수

        for (int n = 2; n <= 1000; n++) {
            int i;

            for (i = 2; i < n; i++) {
                counter++;
                if (n % i == 0) {
                    break;
                }
            }

            if (n == i) { //마지막까지 나누어 떨어지지 않음
                System.out.println(n);
            }
        }

        System.out.println("나눗셈 횟수: " + counter);
    }
}
