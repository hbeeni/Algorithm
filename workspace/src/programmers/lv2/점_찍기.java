package programmers.lv2;

//https://bono039.tistory.com/m/1159
public class 점_찍기 {
	public static long solution(int k, int d) {
		long answer = 0;

		for (long x = 0; x <= d; x += k) { //x좌표를 k 배수만큼 증가시키기
			long y = (long)Math.sqrt((long)d * d - x * x); //피타고라스 정리: x좌표에 대한 최대 y좌표값
			answer += y / k + 1; //0 ~ y 에서 k 배수인 숫자가 몇 개인지 확인 (0좌표 포함시켜야 하므로 +1)
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(2, 4)); //6
		System.out.println(solution(1, 5)); //26
	}
}
