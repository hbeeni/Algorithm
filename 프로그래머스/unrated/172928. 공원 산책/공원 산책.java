class Solution {
    public int[] solution(String[] park, String[] routes) {
        //          N  S   W  E
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        int x = 0;
        int y = 0;

        for (int i = 0; i < park.length; i++) {
            if (park[i].contains("S")) {
                x = i;
                y = park[i].indexOf('S');
                break;
            }
        }

        for (String route : routes) {
            char direction = route.charAt(0);
            int count = route.charAt(2) - '0';
            int idx = 0;
            
            switch (direction) {
                case 'S':
                    idx = 1;
                    break;
                case 'W':
                    idx = 2;
                    break;
                case 'E':
                    idx = 3;
                    break;
            }

            int tempX = x;
            int tempY = y;
            boolean possible = true;
            
            while (--count >= 0) {
                if (tempX + dx[idx] >= 0 && tempX + dx[idx] < park.length &&
                        tempY + dy[idx] >= 0 && tempY + dy[idx] < park[0].length() && 
                        park[tempX + dx[idx]].charAt(tempY + dy[idx]) != 'X') {
                    
                    tempX += dx[idx];
                    tempY += dy[idx];
                    continue;
                }
                possible = false;
            }
            
            if (possible) {
                x = tempX;
                y = tempY;
            }
        }

        return new int[]{x, y};
    }
}