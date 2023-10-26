import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.close();

		int[] cases = new int[n + 2];

		cases[1] = 1;
		cases[2] = 2;

		for (int i = 3; i <= n; i++) {
			cases[i] = (cases[i - 1] + cases[i - 2]) % 10007;
		}

		System.out.println(cases[n]);
	}
}
