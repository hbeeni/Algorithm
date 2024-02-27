import java.time.Duration;
import java.time.LocalTime;

class Solution {
	public String solution(String m, String[] musicinfos) {
		int maxPlayTime = -1;
		String answer = "(None)";
		m = convertNote(m);
		
		for (String infoString : musicinfos) {
			String[] info = infoString.split(",");
			int playTime = calculatePlayTime(info[0], info[1]);

			if (playTime < m.length()) {
				continue;
			}

			String music = convertNote(info[3]);
			int length = music.length();
			if (music.length() > playTime) {
				music = music.substring(0, playTime);
			} else {
				for (int i = 0; i < playTime - length; i++) {
					music += music.charAt(i);
				}
			}

			if (playTime > maxPlayTime && music.contains(m)) {
				maxPlayTime = playTime;
				answer = info[2];
			}
		}

		return answer;
	}

	private int calculatePlayTime(String start, String end) {
		LocalTime startTime = LocalTime.of(
			Integer.parseInt(start.substring(0, 2)), Integer.parseInt(start.substring(3)));
		LocalTime endTime = LocalTime.of(
			Integer.parseInt(end.substring(0, 2)), Integer.parseInt(end.substring(3)));

		Duration duration = Duration.between(startTime, endTime);

		return (int)(duration.getSeconds() / 60);
	}

	private String convertNote(String music) {
		music = music.replaceAll("C#", "c");
		music = music.replaceAll("D#", "d");
		music = music.replaceAll("F#", "f");
		music = music.replaceAll("G#", "g");
		music = music.replaceAll("B#", "b");
		return music.replaceAll("A#", "a");
	}
}
