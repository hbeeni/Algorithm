import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// int n, m 입력받기
		// int count 선언
		// long[n] s 합 배열 선언
		// long[m] r 나머지 배열 선언
		// for i : 1 ~= n
			// 합 배열 구하기
		// for i : 1 ~= n
			// int remainder = s의 나머지 -> r[나머지]++
			// remainder가 0 -> count++
		// for i : 0 ~ m
			// r배열에서 값이 2 이상이면
			// 2개씩 뽑아내는 경우의 수 구해서 count에 더하기
			// -> count += r[i] * (r[i] - 1) / 2;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long count = 0;
		long[] s = new long[n + 1];
		long[] r = new long[m];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) 
			s[i] = s[i - 1] + Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= n; i++) {
			int remainder = (int) (s[i] % m);
			r[remainder]++;
			
			if (remainder == 0)
				count++;
		}
		
		for (int i = 0; i < m; i++)
			if (r[i] >= 2)
				count += (r[i] * (r[i] - 1) / 2);
		
		System.out.println(count);
	}
}
