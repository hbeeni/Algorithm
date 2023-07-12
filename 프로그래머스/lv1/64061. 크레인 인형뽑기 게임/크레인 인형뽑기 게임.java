import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer>[] stacks = new Stack[board.length];

        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new Stack<>();
        }

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    continue;
                }

                stacks[j].push(board[i][j]);
            }
        }

        int result = 0;
        Stack<Integer> basket = new Stack<>();

        for (int move : moves) {
            Stack<Integer> line = stacks[--move];

            if (line.empty()) {
                continue;
            }

            int doll = line.pop();
            boolean flag = false;

            while (!basket.empty() && basket.peek() == doll) {
                flag = true;
                result++;
                basket.pop();
            }

            if (flag) {
                result++;
            } else {
                basket.push(doll);
            }
        }

        return result;
    }
}