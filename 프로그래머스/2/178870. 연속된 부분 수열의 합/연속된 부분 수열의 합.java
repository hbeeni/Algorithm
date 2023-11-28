import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] solution(int[] sequence, int k) {
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == k) {
                return new int[]{i, i};
            }
        }

        Queue<Index> queue = new PriorityQueue<>();
        int l = 0;
        int r = 0;
        int sum = sequence[0];

        while (true) {
            if (sum == k) {
                queue.add(new Index(r - l, l, r));
                l++;
                r++;
                if (r == sequence.length) {
                    break;
                }
                sum += sequence[r] - sequence[l - 1];
            } else if (sum < k) {
                r++;
                if (r == sequence.length) {
                    break;
                }
                sum += sequence[r];
            } else {
                sum -= sequence[l];
                if (l > r) {
                    break;
                }
                l++;
            }
        }

        Index first = queue.poll();
        return new int[] {first.left, first.right};
    }

    static class Index implements Comparable<Index> {
        private int length;
        private int left;
        private int right;

        public Index(int length, int left, int right) {
            this.length = length;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Index o) {
            return length - o.length == 0 ? left - o.left : length - o.length;
        }
    }
}