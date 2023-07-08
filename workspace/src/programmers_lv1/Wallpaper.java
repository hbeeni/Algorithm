package programmers_lv1;

import java.util.Arrays;

public class Wallpaper {
    public static int[] solution(String[] wallpaper) {
        int x1 = 49, y1 = 49;
        int x2 = 0, y2 = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            String line = wallpaper[i];

            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == '#') {
                    x1 = Math.min(x1, i);
                    y1 = Math.min(y1, j);
                    x2 = Math.max(x2, i);
                    y2 = Math.max(y2, j);
                }
            }
        }

        return new int[] {x1, y1, ++x2, ++y2};
    }

    public static void main(String[] args) {
        String[] wallpaper = {".#...", "..#..", "...#."};
        int[] result = solution(wallpaper);
        System.out.println(Arrays.toString(result));
    }
}
