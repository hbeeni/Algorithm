package logic.트리;

import java.util.Scanner;

/* https://www.acmicpc.net/problem/14425
[입력]
5 11
baekjoononlinejudge
startlink
codeplus
sundaycoding
codingsh
baekjoon
codeplus
codeminus
startlink
starlink
sundaycoding
codingsh
codinghs
sondaycoding
startrink
icerink

[출력]
4
 */
public class 트라이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //집합 S의 문자열 개수
		int m = sc.nextInt(); //검사할 문자열 개수
		Node root = new Node();

		//트라이 자료 구조 생성
		//	현재 문자열을 가리키는 위치의 노드가 공백 ---> 신규 노드 생성
		//	아니면 ---> 이동
		//	문자열의 마지막에 도달하면 ---> 리프 노드라고 표시
		for (; n > 0; n--) {
			String text = sc.next();
			Node now = root;

			for (int i = 0; i < text.length(); i++) {
				char c = text.charAt(i);

				if (now.nexts[c - 'a'] == null) {
					now.nexts[c - 'a'] = new Node();
				}

				now = now.nexts[c - 'a'];
				if (i == text.length() - 1) {
					now.isEnd = true;
				}
			}
		}

		//트라이 자료구조 검색으로 집합 S에 포함된 문자열 세기
		//	문자열이 끝날 때까지 공백 상태가 없고, 현재 문자의 마지막 노드가 트라이의 리프 노드라면 포함
		int answer = 0;

		for (; m > 0; m--) {
			String text = sc.next();
			Node now = root;

			for (int i = 0; i < text.length(); i++) {
				char c = text.charAt(i);

				if (now.nexts[c - 'a'] == null) { //공백 노드면 다음 문자열로
					break;
				}

				now = now.nexts[c - 'a'];
				if (i == text.length() - 1 && now.isEnd) {
					answer++;
				}
			}
		}

		System.out.println(answer);
	}

	static class Node {
		Node[] nexts = new Node[26]; //알파벳 26개
		boolean isEnd; //문자열의 마지막 도달 표시
	}
}
