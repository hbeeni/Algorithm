import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        //cache: 현재 캐시, set: cache에 들어있는 값
        Queue<String> cache = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int answer = 0;

        //cacheSize = 0 -> cities 길이 * 5
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        /*
        city가 set에 있으면
            answer += 1
            cache에서 city를 remove하고 다시 넣기 
        city가 set에 없으면
            answer += 5
                set 사이즈 == 캐시 사이즈
                    cache에서 하나 빼기
                    뺀 값을 set에서도 빼기
            set,cache에 city 넣기
        */
        for (String city : cities) {
            city = city.toLowerCase();

            if (set.contains(city)) {
                answer++;
                cache.remove(city);
                cache.add(city);
            } else {
                answer += 5;
                if (set.size() == cacheSize) {
                    set.remove(cache.poll());
                }
                set.add(city);
                cache.add(city);
            }
        }
        
        return answer;
    }
}