package logic.그래프;

import java.util.Scanner;

//https://www.acmicpc.net/problem/1717
/*
[입력]
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1

[출력]
NO
NO
YES
 */
public class 유니온파인드 {

	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		//처음에는 노드 연결 X -> 각 노드가 대표 노드 = 자신의 인덱스 값으로 초기화
		parent = new int[n + 1];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			int q = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();

			if (q == 0) {
				union(a, b);
			} else {
				if (checkSameSet(a, b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

	//union: 2개의 노드를 선택해 각각의 "대표 노드를 찾아 연결"
	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			parent[b] = a;
		}
	}

	//find: 자신이 속한 집합의 대표 노드를 찾음
	static int find(int a) {

		//1. 대상 노드 배열에 index 값과 value 값이 동일한지 확인
		//2. 동일하지 않으면 value 값이 가리키는 index 위치로 이동
		//3. 이동 위치의 index 값과 value 값이 같을 때까지 1~2 반복 ---> 재귀 함수
		//4. 대표 노드에 도달하면 재귀 함수를 빠져나오면서 "모든 노드값을 루트 노드값으로 변경"

		if (a == parent[a]) {
			return a;
		}

		return parent[a] = find(parent[a]);
	}

	//두 원소가 같은 집합인지 확인
	static boolean checkSameSet(int a, int b) {
		a = find(a);
		b = find(b);

		return a == b;
	}
}
