//https://maicoding.tistory.com/70

package programmers.lv2;

public class 피로도 {
    static int max = 0;

    public static int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        explore(dungeons, visited, k, 0);
        return max;
    }

    private static void explore(int[][] dungeons, boolean[] visited, int k, int count) {
        //최소 피로도 충족: 소모 피로도 감소시킨 후 다음 던전으로
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) { //던전을 방문한 적이 없고, 던전의 최소 피로도가 현재 피로도를 넘지 않을 때
                visited[i] = true;
                explore(dungeons, visited, k - dungeons[i][1], count + 1);
                visited[i] = false;
            }
        }

        //최소 피로도 미충족: 현재까지의 탐험횟수와 최대 탐험횟수를 비교해서 큰 쪽을 최대 탐험횟수로 변경
        max = Math.max(max, count);
    }

    public static void main(String[] args) {
        System.out.println(solution(80, new int[][]{
                {80, 20},
                {50, 40},
                {30, 10}
        })); //3
    }
}
