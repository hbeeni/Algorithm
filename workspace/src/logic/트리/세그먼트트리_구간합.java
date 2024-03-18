package logic.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* https://www.acmicpc.net/problem/2042
[입력]
5 2 2
1
2
3
4
5
1 3 6
2 2 5
1 5 2
2 3 5

[출력]
17
12
 */
public class 세그먼트트리_구간합 {

	static long[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); //수의 개수
		int m = Integer.parseInt(st.nextToken()); //변경이 일어나는 횟수
		int k = Integer.parseInt(st.nextToken()); //구간의 합을 구하는 횟수

		//배열 크기 구하기 (height 구하기) ---> 배열 크기 = 2^(h + 1) (h = 2^h ≥ n을 만족하는 h의 최솟값)
		int h = 0;
		int temp = n;

		while (temp != 0) {
			temp /= 2;
			h++;
		}

		int length = (int)Math.pow(2, h + 1);
		tree = new long[length];
		int leftNodeStartIndex = length / 2;

		//데이터를 리프 노드에 입력받기
		for (int i = leftNodeStartIndex; i < leftNodeStartIndex + n; i++) {
			tree[i] = Long.parseLong(br.readLine());
		}

		//트리 만들기
		setTree(length - 1);

		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			long e = Long.parseLong(st.nextToken());

			if (a == 1) { //데이터 업데이트
				changeValue(leftNodeStartIndex + s - 1, e);
			} else { //구간합
				s += leftNodeStartIndex - 1;
				e += leftNodeStartIndex - 1;
				System.out.println(getSum(s, (int)e));
			}
		}

		br.close();
	}

	//구간합 구하기
	private static long getSum(int s, int e) {
		long sum = 0;

		while (s <= e) {
			if (s % 2 == 1) {
				sum += tree[s]; //선택된 노드 더하기
				s++;
			}

			if (e % 2 == 0) {
				sum += tree[e]; //선택된 노드 더하기
				e--;
			}

			s /= 2;
			e /= 2;
		}

		return sum;
	}

	//데이터 업데이트
	private static void changeValue(int index, long value) {
		long diff = value - tree[index];

		while (index > 0) {
			tree[index] += diff;
			index /= 2;
		}
	}

	//트리 부모 노드 초기화
	private static void setTree(int n) {
		for (int i = n; i > 0; i--) {
			tree[i / 2] += tree[i]; //부모 노드 구하기
		}
	}
}
