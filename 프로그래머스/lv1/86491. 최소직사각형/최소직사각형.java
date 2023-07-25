class Solution {
    public int solution(int[][] sizes) {
        int x = 0, y = 0;
        
        for (int[] size : sizes) {
            int a = Math.max(size[0], size[1]);
            int b = Math.min(size[0], size[1]);
            x = Math.max(a, x);
            y = Math.max(b, y);
        }
        
        return x * y;
    }
}