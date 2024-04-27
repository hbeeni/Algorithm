package programmers.lv2;

//대각선이 지나는 단위정사각형: https://m.blog.naver.com/PostView.nhn?blogId=zzinuhelios&logNo=120024685950&proxyReferer=https:%2F%2Fwww.google.com%2F
//https://hyojun.tistory.com/entry/Programmers-%EB%A9%80%EC%A9%A1%ED%95%9C-%EC%82%AC%EA%B0%81%ED%98%95-Java
public class 멀쩡한_사각형 {
	public static long solution(int w, int h) {
		long a = w;
		long b = h;

		return a * b - (a + b - gcd(a, b));
	}

	public static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	public static void main(String[] args) {
		System.out.println(solution(8, 12)); //80
		System.out.println(solution(12, 8)); //80
		System.out.println(solution(4, 4)); //12
	}
}
