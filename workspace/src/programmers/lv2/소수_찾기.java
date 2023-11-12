//https://hu-coding.tistory.com/132

package programmers.lv2;

import java.util.HashSet;
import java.util.Set;

public class 소수_찾기 {

    static Set<Integer> set = new HashSet<>();
    static char[] arr; //종이 조각
    static boolean[] visited;

    public static int solution(String numbers) {
        arr = new char[numbers.length()];
        visited = new boolean[numbers.length()];

        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = numbers.charAt(i);
        }

        recursion("", 0);
        System.out.println("set = " + set);
        return set.size();
    }

    //DFS 재귀. 가능한 숫자 조합을 찾고, 소수면 set에 추가
    public static void recursion(String str, int index) {
        System.out.println("str: " + str + ", index: " + index);
        int num;
        if (!str.isEmpty()) {
            num = Integer.parseInt(str);
            if (isPrime(num)) {
                set.add(num);
            }
        }
        if (index == arr.length) { //끝까지 다했을 때
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                System.out.println("i: " + i + ", str: " + str);
                recursion(str + arr[i], index + 1);
                System.out.println("after recursion - i: " + i + ", str: " + str);
                visited[i] = false; //백트래킹
            }
        }
    }

    //소수 판별
    public static boolean isPrime(int n) {
        if (n == 1 || n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("17")); //3
        set.clear();
        System.out.println(solution("011")); //2
    }
}
