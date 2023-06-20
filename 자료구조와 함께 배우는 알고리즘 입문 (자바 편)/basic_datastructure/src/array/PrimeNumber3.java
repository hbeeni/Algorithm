//1000이하의 소수 나열 (버전 3)

package array;

public class PrimeNumber3 {
    public static void main(String[] args) {
        int counter = 0; //곱셈 + 나눗셈 횟수
        int ptr = 0; //찾은 소수 개수 (포인터)
        int[] prime = new int[500]; //소수 저장 배열

        prime[ptr++] = 2;
        prime[ptr++] = 3;

        for (int n = 5; n <= 1000; n += 2) {
            boolean flag = false;

            for (int i = 1; prime[i] * prime[i] <= n; i++) {
                counter += 2;

                if (n % prime[i] == 0) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                prime[ptr++] = n;
                counter++; //prime[i] * prime[i] <= n이 성립하지 않으면 곱셈이 수행 횟수에 포함되지 않아서 여기서 포함
            }
        }

        for (int i = 0; i < ptr; i++) {
            System.out.println(prime[i]);
        }

        System.out.println("나눗셈 횟수: " + counter);
    }
}
