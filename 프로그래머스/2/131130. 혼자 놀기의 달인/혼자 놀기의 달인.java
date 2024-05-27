import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {

	private static List<Integer> list = new ArrayList<>();
	private int[] a;
	private boolean[] visited;
	
	public int solution(int[] cards) {
		a = new int[cards.length + 1];
		visited = new boolean[cards.length + 1];
		
		System.arraycopy(cards, 0, a, 1, cards.length);

		for (int i = 1; i < a.length; i++) {
			dfs(i, 0);
		}
		
		if (list.size() == 1) {
			return 0;
		}
		
		list.sort(Comparator.reverseOrder());
		return list.get(0) * list.get(1);
	}
	
	private void dfs(int idx, int count) {
		if (visited[idx]) {
			list.add(count);
			return;
		}
		
		visited[idx] = true;
		dfs(a[idx], count + 1);
	}
}