import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
	public int solution(String[][] bookTime) {
		PriorityQueue<LocalDateTime[]> inQueue = new PriorityQueue<>(Comparator.comparing(arr -> arr[0]));

		for (String[] time : bookTime) {
			String checkIn = time[0];
			String checkOut = time[1];

			LocalDateTime[] arr = new LocalDateTime[2];
			arr[0] = LocalDateTime.parse("2007-12-03T"+checkIn);
			arr[1] = LocalDateTime.parse("2007-12-03T"+checkOut).plusMinutes(10L);

			inQueue.add(arr);
		}

		int answer = 0;
		PriorityQueue<LocalDateTime> outQueue = new PriorityQueue<>();

		for (int i = 0; i < bookTime.length; i++) {
			LocalDateTime[] time = inQueue.poll();

			if (!outQueue.isEmpty() && outQueue.peek().compareTo(time[0]) <= 0) {
				outQueue.poll();
			}

			outQueue.add(time[1]);
			answer = Math.max(outQueue.size(), answer);
		}

		return answer;
	}
}
