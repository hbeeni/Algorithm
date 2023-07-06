import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// N : 수의 개수
		// A : 수 데이터 저장 배열
		// for (N만큼 반복하기)
			// A 배열에 데이터 저장하기
		// A 배열 정렬하기
		// for (current를 0부터 N까지 반복)
			// 변수 초기화하기 (찾고자 하는 값 find, 포인터 start, end)
			// while (start < end)
				// if (A[start] + A[end] == 찾고자 하는 값)
					// start, end가 current가 아닐 때 결괏값에 반영 및 while문 종료
					// start, end가 current가 맞을 때 포인터 변경 및 계속 수행하기
				// else if (A[start] + A[end] < 찾고자 하는 값) start 증가
				// else end 감소
		// 수의 개수 출력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] A = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(A);
		
		int count = 0;
		
		for (int current = 0; current < N; current++) {
			long num = A[current];
			int start = 0;
			int end = N - 1;
			
			while (start < end) {
				if (A[start] + A[end] == num) {
					if (start != current && end != current) {
						count++;
						break;
					} else if (start == current) {
						start++;
					} else if (end == current) {
						end--;
					}
				} else if (A[start] + A[end] < num) {
					start++;
				} else {
					end--;
				}
			}
		}
		
		System.out.println(count);
		br.close();
	}
}
