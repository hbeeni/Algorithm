import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		// 수열의 크기 N
		// 수열 int[N] A, stack, 정답 배열 int answer[N] 선언
		// for N
			// A에 숫자 입력받기
		// for N
			// while 스택이 비어있지 않고, 현재 수열 값이 top에 해당하는 수열보다 클 때까지
				// pop
				// 정답 배열에 오큰수를 현재 수열로 저장
			// 현재 수열을 스택에 push
		// while 스택이 빌 때까지
			// 스택에 있는 인덱스의 정답 배열에 -1 저장
		// 정답 배열 출력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] A = new int[n];
		int[] ans = new int[n];
		
		String[] str = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			A[i] = Integer.parseInt(str[i]);
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0); // 처음에는 스택이 항상 비어있으므로 최초 값을 push해서 초기화
		
		for (int i = 1; i < n; i++) {
			while (!stack.isEmpty() && A[i] > A[stack.peek()]) {
				ans[stack.pop()] = A[i];
			}
			
			stack.push(i);
		}
		
		while (!stack.isEmpty())
			ans[stack.pop()] = -1;
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < n; i++) {
			bw.write(ans[i] + " ");
		}
		
		bw.write("\n");
		bw.flush();
	}
}
