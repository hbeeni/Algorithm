import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] a = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		int s = 0;
		int e = k - 1;
		for (int i = 0; i < k; i++) {
			sum += a[i];
		}
		int max = sum;
		
		while (true) {
			sum -= a[s];
			s++;
			e++;
			if (e == n) {
				break;
			}
			sum += a[e];

			if (max < sum) {
				max = sum;
			}
		}

		System.out.println(max);
	}
}
