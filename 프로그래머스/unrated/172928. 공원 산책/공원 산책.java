import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int maxX = park.length;
        int maxY = park[0].length();
        
        boolean[][] coor = new boolean[maxX][maxY];
        int[] answer = new int[2];
        
        for (int x = 0; x < maxX; x++) {
            String[] tmp = park[x].split("");
            
            for (int y = 0; y < maxY; y++) {
                if (tmp[y].equals("S")) {
                    answer[0] = x;
                    answer[1] = y;
                }
                if (!tmp[y].equals("X")) {
                    coor[x][y] = true;
                }
            }
        }
        
        for (int i = 0; i < routes.length; i++) {
            String[] tmp = routes[i].split(" ");
            String dir = tmp[0];
            int count = Integer.parseInt(tmp[1]);
            
            int x = answer[0];
            int y = answer[1];
            
            for (int j = 0; j < count; j++) {
                switch (dir) {
                case "N":
                    x--;
                    break;
                case "S":
                    x++;
                    break;
                case "W":
                    y--;
                    break;
                case "E":
                    y++;
                    break;
                }
                
                if (!(x >= 0 && y >= 0 && x < maxX && y < maxY && coor[x][y])) {
                    break;
                }
                
                if (j == count - 1) {
                    answer[0] = x;
                    answer[1] = y;
                }
            }
        }
        
        return answer;
    }
}