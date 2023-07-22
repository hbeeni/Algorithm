class Solution {
    public String solution(String s) {
        String[] strNum = s.split(" ");
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < strNum.length; i++) {
            int num = Integer.parseInt(strNum[i]);
            
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        
        return min + " " + max;
    }
}