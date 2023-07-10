import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		/*
		int N 입력받기
		Queue q 선언
		for i : 0 ~ N {
			q에 i+1 add
		}
		
		while : q의 size가 1일 때까지
			q의 first 값 제거
			q의 first 값 제거 후 그 값을 add
		*/
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 0; i < N; i++)
			q.add(i + 1);
		
		while (q.size() > 1) {
			q.poll();
			q.add(q.poll());
		}
		
		System.out.println(q.poll());
	}
}
