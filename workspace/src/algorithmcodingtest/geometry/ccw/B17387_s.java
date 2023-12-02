package algorithmcodingtest.geometry.ccw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17387_s {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int x3 = Integer.parseInt(st.nextToken());
		int y3 = Integer.parseInt(st.nextToken());
		int x4 = Integer.parseInt(st.nextToken());
		int y4 = Integer.parseInt(st.nextToken());

		boolean cross = isCross(x1, y1, x2, y2, x3, y3, x4, y4);
		if (cross) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	private static boolean isCross(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		int abc = ccw(x1, y1, x2, y2, x3, y3);
		int abd = ccw(x1, y1, x2, y2, x4, y4);
		int cda = ccw(x3, y3, x4, y4, x1, y1);
		int cdb = ccw(x3, y3, x4, y4, x2, y2);

		if (abc * abc == 0 && cda * cdb == 0) { //선분이 일직선일 때
			return isOverlab(x1, y1, x2, y2, x3, y3, x4, y4); //겹치는 선분인지 판별
		} else {
			return abc * abd <= 0 && cda * cdb <= 0; //선분이 교차하면 true
		}
	}

	//선분 겹침 여부 판별
	private static boolean isOverlab(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		return Math.min(x1, x2) <= Math.max(x3, x4) && Math.min(x3, x4) <= Math.max(x1, x2)
				&& Math.min(y1, y2) <= Math.max(y3, y4) && Math.min(y3, y4) <= Math.max(y1, y2);
	}

	private static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
		int result = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);
		return Integer.compare(result, 0);
	}
}
