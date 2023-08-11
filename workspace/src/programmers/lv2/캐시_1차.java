//https://ilmiodiario.tistory.com/106

package programmers.lv2;

import java.util.LinkedList;

public class 캐시_1차 {
    public static int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        LinkedList<String> cache = new LinkedList<>();
        int answer = 0;

        for (String city : cities) {
            city = city.toLowerCase();

            if (cache.remove(city)) {
                answer++;
            } else {
                answer += 5;
                if (cache.size() == cacheSize) {
                    cache.remove(0);
                }
            }
            cache.add(city);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"})); //50
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"})); //21
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"})); //60
        System.out.println(solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"})); //52
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"})); //16
        System.out.println(solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"})); //25
    }
}
