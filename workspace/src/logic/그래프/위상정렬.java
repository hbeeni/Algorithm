package logic.그래프;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* https://www.acmicpc.net/problem/2252
[입력]
3 2
1 3
2 3

[출력]
1 2 3
 */
public class 위상정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		//1. 인접 리스트에 노드 데이터 저장 & 집입 차수 배열값 업데이트 --- 진입차수(in-degree): 자기 자신을 가리키는 에지의 개수
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		int[] indegree = new int[n + 1];
		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();

			list.get(s).add(e);
			indegree[e]++;
		}

		//2. 위상 정렬 수행
		//2-1. 진입 차수가 0인 노드를 큐에 저장
		//2-2. 큐에서 데이터를 poll해 해당 노드를 탐색 결과에 추가하고, 해당 노드가 가리키는 노드의 진입 차수를 1씩 감소
		//2-3. 감소했을 때 진입 차수가 0이 되는 노드를 큐에 offer
		//2-4. 큐가 빌 때까지 1~3 반복

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + " ");
			for (int next : list.get(now)) {
				indegree[next]--;
				if (indegree[next] == 0) {
					queue.offer(next);
				}
			}
		}
	}
}
