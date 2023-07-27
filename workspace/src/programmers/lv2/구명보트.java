//https://velog.io/@ajufresh/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EA%B5%AC%EB%AA%85%EB%B3%B4%ED%8A%B8-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-Java

package programmers.lv2;

import java.util.Arrays;

public class 구명보트 {
    public static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int min = 0, max = people.length - 1;

        for (; min <= max; max--) {
            if (people[min] + people[max] <= limit) {
                min++;
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{50}, 50)); //1
        System.out.println(solution(new int[]{20, 50, 50, 80}, 100)); //2
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100)); //3
        System.out.println(solution(new int[]{50, 30, 20, 70, 10}, 100)); //3
        System.out.println(solution(new int[]{70, 80, 50}, 100)); //3
        System.out.println(solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100)); //5
    }
}
