class Solution { 
    static int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    answer[0]++;
                } else {
                    answer[1]++;
                }
            }
        }

        if (answer[0] == 0) {
            return new int[]{0, 1};
        } else if (answer[1] == 0) {
            return new int[]{1, 0};
        }
        
        int range = arr.length / 2;
        compress(arr, 0, 0, range);
        compress(arr, 0, range, range);
        compress(arr, range, 0, range);
        compress(arr, range, range, range);
        
        return answer;
    }

    public void compress(int[][] arr, int x, int y, int range) {
        if (range < 2) {
            return;
        }
        
        int num = arr[x][y];
        boolean same = true;
        Loop: for (int i = x; i < x + range; i++) {
            for (int j = y; j < y + range; j++) {
                if (arr[i][j] != num) {
                    same = false;
                    break Loop;
                }
            }
        }

        if (same) {
            answer[num] -= range * range - 1;
        } else {
            range /= 2;
            compress(arr, x, y, range);
            compress(arr, x, y + range, range);
            compress(arr, x + range, y, range);
            compress(arr, x + range, y + range, range);
        }
    } 
}