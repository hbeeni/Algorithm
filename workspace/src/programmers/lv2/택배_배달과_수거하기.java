package programmers.lv2;

//https://stritegdc.tistory.com/317
public class 택배_배달과_수거하기 {
	public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0L;

		int delivery = 0;
		int pickup = 0;

		for (int i = n - 1; i >= 0; i--) {
			delivery -= deliveries[i];
			pickup -= pickups[i];

			//둘 다 양수 = 아직 트럭 용량에 여유가 있다.
			//둘 중 하나 음수 = 용량 여유가 없다.
			while (delivery < 0 || pickup < 0) {
				delivery += cap;
				pickup += cap;
				answer += i + 1;
			}
		}

		return answer * 2;
	}

	public static void main(String[] args) {
		System.out.println(solution(4, 5, new int[] {1, 0, 3, 1, 2}, new int[] {0, 3, 0, 4, 0}));
		System.out.println(solution(2, 7, new int[] {1, 0, 2, 0, 1, 0, 2}, new int[] {0, 2, 0, 1, 0, 2, 0}));
	}
}
