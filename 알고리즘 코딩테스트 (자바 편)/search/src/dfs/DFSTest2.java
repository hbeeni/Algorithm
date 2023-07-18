package dfs;

import java.util.ArrayList;
import java.util.Stack;

public class DFSTest2 {

    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void dfs(int x) {
        Stack<Integer> stack = new Stack<>();
        stack.push(x);
        visited[x] = true;

        while (!stack.isEmpty()) {
            int i = stack.pop();
            System.out.print(i + " ");

            for (int j = 0; j < graph.get(i).size(); j++) {
                Integer cur = graph.get(i).get(j);

                if (!visited[cur]) {
                    stack.push(cur);
                    visited[cur] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 9;

        //visited 초기화
        visited = new boolean[9];

        //graph 초기화
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        //노드 1에 연결된 노드 정보 저장
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        //노드 2에 연결된 노드 정보 저장
        graph.get(2).add(1);
        graph.get(2).add(7);

        //노드 3에 연결된 노드 정보 저장
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        //노드 4에 연결된 노드 정보 저장
        graph.get(4).add(3);
        graph.get(4).add(5);

        //노드 5에 연결된 노드 정보 저장
        graph.get(5).add(3);
        graph.get(5).add(4);

        //노드 6에 연결된 노드 정보 저장
        graph.get(6).add(7);

        //노드 7에 연결된 노드 정보 저장
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        //노드 8에 연결된 노드 정보 저장
        graph.get(8).add(1);
        graph.get(8).add(7);

        dfs(1);
    }
}
