class Solution {
    public int[] solution(String[] wallpaper) {
        int x1 = -1, y1 = 100;
        int x2 = -1, y2 = -1;
        
        for (int i = 0; i < wallpaper.length; i++) {
            if (x1 == -1 && wallpaper[i].contains("#")) {
                x1 = i;
            }
            if (x2 == -1 && wallpaper[wallpaper.length - 1 - i].contains("#")) {
                x2 = wallpaper.length - i;
            }
            if (x1 != -1 && x2 != -1) {
                break;
            }
        }
        
        for (int i = 0; i < wallpaper.length; i++) {
            int idx1 = wallpaper[i].indexOf("#");
            int idx2 = wallpaper[i].lastIndexOf("#");
            
            if (idx1 != -1 && idx1 < y1) {
                y1 = idx1;
            }
            if (idx2 != -1 && idx2 + 1 > y2) {
                y2 = idx2 + 1;
            }
        }
        
        return new int[] {x1, y1, x2, y2};
    }
}