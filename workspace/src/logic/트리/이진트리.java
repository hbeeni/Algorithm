package logic.트리;

import java.util.Scanner;

/* https://www.acmicpc.net/problem/1991
[입력]
7
A B C
B D .
C E F
E . .
F . G
D . .
G . .

[출력]
ABDCEFG
DBAECFG
DBEGFCA
 */
public class 이진트리 {

	static int[][] tree = new int[26][2]; //0 -> 왼쪽 자식 노드[1] -> 오른쪽 자식 노드[2]

	//트리 순회
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			String[] split = sc.nextLine().split(" ");
			int node = split[0].charAt(0) - 'A'; //node index
			char left = split[1].charAt(0);
			char right = split[2].charAt(0);

			//자식 노드가 없으면 -1 저장
			if (left == '.') {
				tree[node][0] = -1;
			} else {
				tree[node][0] = left - 'A';
			}
			if (right == '.') {
				tree[node][1] = -1;
			} else {
				tree[node][1] = right - 'A';
			}
		}

		preOrder(0);
		System.out.println();

		inOrder(0);
		System.out.println();

		postOrder(0);
		System.out.println();
	}

	public static void preOrder(int now) {
		if (now == -1) {
			return;
		}

		System.out.print((char)(now + 'A')); //1. 현재 노드
		preOrder(tree[now][0]); //2. 왼쪽 탐색
		preOrder(tree[now][1]); //3. 오른쪽 탐색
	}

	public static void inOrder(int now) {
		if (now == -1) {
			return;
		}

		inOrder(tree[now][0]); //1. 왼쪽 탐색
		System.out.print((char)(now + 'A')); //2. 현재 노드
		inOrder(tree[now][1]); //3. 오른쪽 탐색
	}

	public static void postOrder(int now) {
		if (now == -1) {
			return;
		}

		postOrder(tree[now][0]); //1. 왼쪽 탐색
		postOrder(tree[now][1]); //2. 오른쪽 탐색
		System.out.print((char)(now + 'A')); //3. 현재 노드
	}
}
