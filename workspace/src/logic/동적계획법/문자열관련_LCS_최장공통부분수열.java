//문자열과 관련된 동적 계획법은 이런식으로 풀이하는 경우 많음

package logic.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
LCS(Longest Common Subsequence, 최장 공통 부분 수열)
- 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것
- 알고리즘 코딩테스트 책 510p 참고

[입력]
ACAYKP
CAPCAK

[출력]
4
ACAK
 */
public class 문자열관련_LCS_최장공통부분수열 {

	static long[][] dp;
	static char[] a;
	static char[] b;
	static List<Character> path; //LCS 저장 리스트

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = br.readLine().toCharArray();
		b = br.readLine().toCharArray();
		dp = new long[a.length + 1][b.length + 1];
		path = new ArrayList<>();

		for (int i = 1; i <= a.length; i++) {
			for (int j = 1; j <= b.length; j++) {
				if (a[i - 1] == b[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1; //같은 문자열일 때 왼쪽 대각선 값 + 1
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); //다르면 왼쪽과 위의 값 중 큰 수
				}
			}
		}

		System.out.println(dp[a.length][b.length]);
		getText(a.length, b.length);
		for (int i = path.size() - 1; i >= 0; i--) {
			System.out.print(path.get(i));
		}
	}

	//LCS 출력
	private static void getText(int r, int c) {
		if (r == 0 || c == 0) {
			return;
		}
		if (a[r - 1] == b[c - 1]) { //같으면 LCS에 기록하고 왼쪽 위로 이동
			path.add(a[r - 1]);
			getText(r - 1, c - 1);
		} else { //다르면 왼쪽과 위 중 큰 수로 이동
			if (dp[r - 1][c] > dp[r][c - 1]) {
				getText(r - 1, c);
			} else {
				getText(r, c - 1);
			}
		}
	}
}
