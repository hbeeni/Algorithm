import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = strToMap(str1);
        Map<String, Integer> map2 = strToMap(str2);

        if (map1.isEmpty() && map2.isEmpty()) {
            return 65536;
        }

        double kyo = 0, hap = 0;
        for (String key1 : map1.keySet()) {
            if (map2.containsKey(key1)) {
                kyo += Math.min(map1.get(key1), map2.get(key1));
                hap += Math.max(map1.get(key1), map2.get(key1));
                map2.remove(key1);
            } else {
                hap += map1.get(key1);
            }
        }

        for (String key2 : map2.keySet()) {
            hap += map2.get(key2);
        }

        return (int) (kyo / hap * 65536);
    }

    private Map<String, Integer> strToMap(String str) {
        Map<String, Integer> map = new HashMap<>();
        str = str.toLowerCase();

        for (int i = 0; i < str.length() - 1; i++) {
            String subStr = str.substring(i, i + 2);
            if ((subStr.charAt(0) >= 'a' && subStr.charAt(0) <= 'z') &&
                    (subStr.charAt(1) >= 'a' && subStr.charAt(1) <= 'z')) {
                map.put(subStr, map.getOrDefault(subStr, 0) + 1);
            }
        }

        return map;
    }
}