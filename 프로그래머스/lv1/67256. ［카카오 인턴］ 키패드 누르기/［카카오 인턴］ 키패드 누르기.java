class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuffer sb = new StringBuffer();
        hand = String.valueOf(hand.charAt(0)).toUpperCase();
        int[][] keypad = {
            {1, 2, 3},
            {4, 5, 6},  
            {7, 8, 9},  
            {10, 11, 12}
        };
        
        int leftX = 3, leftY = 0;
        int rightX = 3, rightY = 2;
        
        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                sb = sb.append("L");
                leftX = (num - 1) / 3;
                leftY = 0;
            } else if (num == 3 || num == 6 || num == 9) {
                sb = sb.append("R");
                rightX = (num - 1) / 3;
                rightY = 2;
            } else {
                if (num == 0) {
                    num = 11;
                }
                
                int targetX = 0, targetY = 0;
                
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (num == keypad[i][j]) {
                            targetX = i;
                            targetY = j;
                        }
                    }
                }
                
                int lCount = Math.abs(targetX - leftX) + Math.abs(targetY - leftY);
                int rCount = Math.abs(targetX - rightX) + Math.abs(targetY - rightY);
                
                if (lCount == rCount) {
                    sb = sb.append(hand);
                    
                    if (hand.equals("L")) {
                        leftX = targetX;
                        leftY = targetY;
                    } else {
                        rightX = targetX;
                        rightY = targetY;
                    }
                } else if (lCount < rCount) {
                    sb = sb.append("L");
                    leftX = targetX;
                    leftY = targetY;
                } else {
                    sb = sb.append("R");
                    rightX = targetX;
                    rightY = targetY;
                }
            }
        }
        
        return sb.toString();
    }
}