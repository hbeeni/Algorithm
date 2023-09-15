import java.util.PriorityQueue;

class Solution {
    int solution(int[][] land) {
        PriorityQueue<Space> queue = new PriorityQueue<>();

        for (int col = 0; col < land[0].length; col++) {
            queue.add(new Space(col, land[0][col]));
        }
        
        for (int row = 1; row < land.length; row++) {
            Space first = queue.poll();
            Space second = queue.poll();
            queue.clear();
            
            for (int col = 0; col < land[0].length; col++) {
                if (col == first.column) {
                    land[row][col] += second.value;
                } else {
                    land[row][col] += first.value;
                }
                queue.add(new Space(col, land[row][col]));
            }
        }

        int answer = 0;
        for (int col = 0; col < land[0].length; col++) {
            answer = Math.max(answer, land[land.length - 1][col]);
        }
        return answer;
    }
    
    class Space implements Comparable<Space> {
        int column;
        int value;

        public Space(int column, int value) {
            this.column = column;
            this.value = value;
        }

        @Override
        public int compareTo(Space o) {
            return o.value - this.value;
        }
    }
}