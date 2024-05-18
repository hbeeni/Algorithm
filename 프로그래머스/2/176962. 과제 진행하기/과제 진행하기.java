import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

class Solution {
	public String[] solution(String[][] plans) {
		Arrays.sort(plans, Comparator.comparing(p -> p[1]));

		List<String> answer = new ArrayList<>();
		Stack<String[]> stack = new Stack<>();

		for (int i = 0; i < plans.length - 1; i++) {
			String[] now = plans[i];
			String[] next = plans[i + 1];

			int nowPlaytime = Integer.parseInt(now[2]);
			int duration = getDuration(now[1], next[1]);

			if (duration == nowPlaytime) {
				answer.add(now[0]);
			} else if (duration < nowPlaytime) {
				stack.push(new String[] {now[0], String.valueOf(nowPlaytime - duration)});
			} else {
				answer.add(now[0]);
				duration -= nowPlaytime;

				while (duration > 0 && !stack.isEmpty()) {
					String[] task = stack.pop();
					int taskPlaytime = Integer.parseInt(task[1]);

					if (duration == taskPlaytime) {
						answer.add(task[0]);
						break;
					} else if (duration < taskPlaytime) {
						task[1] = String.valueOf(taskPlaytime - duration);
						stack.push(task);
						break;
					} else {
						answer.add(task[0]);
						duration -= taskPlaytime;
					}
				}
			}
		}

		answer.add(plans[plans.length - 1][0]);

		while (!stack.isEmpty()) {
			answer.add(stack.pop()[0]);
		}

		return answer.toArray(new String[0]);
	}

	private int getDuration(String now, String next) {
		String[] splitNow = now.split(":");
		String[] splitNext = next.split(":");

		int min = Integer.parseInt(splitNext[1]) - Integer.parseInt(splitNow[1]);
		int hour = Integer.parseInt(splitNext[0]) - Integer.parseInt(splitNow[0]);

		return hour * 60 + min;
	}
}
