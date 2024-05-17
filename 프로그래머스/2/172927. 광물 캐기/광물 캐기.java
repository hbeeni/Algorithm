import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

	private static final int[] DIAMOND_PICK = {1, 1, 1};
	private static final int[] IRON_PICK = {5, 1, 1};
	private static final int[] STONE_PICK = {25, 5, 1};
	private static final List<int[]> PICK_INDEX = new ArrayList<>();

	static {
		PICK_INDEX.add(DIAMOND_PICK);
		PICK_INDEX.add(IRON_PICK);
		PICK_INDEX.add(STONE_PICK);
	}

	public int solution(int[] picks, String[] minerals) {
		int pickCount = 0;
		for (int pick : picks) {
			pickCount += pick;
		}

		String[] canBeMined = new String[Math.min(minerals.length, pickCount * 5)];
		System.arraycopy(minerals, 0, canBeMined, 0, canBeMined.length);

		Queue<Info> queue = new PriorityQueue<>();

		for (int i = 0; i < canBeMined.length; i += 5) {
			Info info = new Info();

			for (int j = i; j < Math.min(i + 5, canBeMined.length); j++) {
				info.getMineral(canBeMined[j]);
			}

			queue.add(info);
		}

		int answer = 0;

		Outer:
		for (int i = 0; i < picks.length; i++) {
			for (int j = 0; j < picks[i]; j++) {
				Info info = queue.poll();
				answer += info.getTotal(PICK_INDEX.get(i));

				if (queue.isEmpty()) {
					break Outer;
				}
			}
		}

		return answer;
	}

	private static class Info implements Comparable<Info> {
		int diamond;
		int iron;
		int stone;

		public void getMineral(String mineral) {
			switch (mineral) {
				case "diamond":
					diamond++;
					break;
				case "iron":
					iron++;
					break;
				default:
					stone++;
					break;
			}
		}

		public int getTotal(int[] pick) {
			return pick[0] * diamond + pick[1] * iron + pick[2] * stone;
		}

		@Override
		public int compareTo(Info i) {
			int diaDiff = i.diamond - diamond;
			int ironDiff = i.iron - iron;
			int stoneDiff = i.stone - stone;

			if (diaDiff != 0) {
				return diaDiff;
			}

			return ironDiff != 0 ? ironDiff : stoneDiff;
		}
	}
}
