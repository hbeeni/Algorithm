import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		int result
		for (i: 0 ~ N) {
			result에 i 번째 값 * (N - i) 누적
		}
		*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(P);
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			result += P[i] * (N - i);
		}
		
		System.out.println(result);
	}
}
