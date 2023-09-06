//https://yeoeun-ji.tistory.com/144

package programmers.lv2;

public class 타겟_넘버 {
    static int count = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return count;
    }

    /**
     * @param depth  이진트리 깊이
     * @param result 이전 노드까지의 합계
     */
    public void dfs(int[] numbers, int depth, int target, int result) {
        if (depth == numbers.length) { //마지막 노드까지 진행했을 때
            if (target == result) { //target 값과 합계가 같다면
                count++;
            }
        } else {
            dfs(numbers, depth + 1, target, result + numbers[depth]);
            dfs(numbers, depth + 1, target, result - numbers[depth]);
        }
    }

    public static void main(String[] args) {
        타겟_넘버 t = new 타겟_넘버();
        System.out.println(t.solution(new int[]{1, 1, 1, 1, 1}, 3)); //5
        count = 0;
        System.out.println(t.solution(new int[]{4, 1, 2, 1}, 4)); //2
    }
}
