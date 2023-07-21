class Solution {
    public String solution(int a, int b) {
        String[] dayOfWeek = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int[] lastDayOfMonth = {0,31,29,31,30,31,30,31,31,30,31,30,31};
        
        int day = b;
        for (int i = 1; i < a; i++) {
            day += lastDayOfMonth[i];
        }
        
        return dayOfWeek[day % 7];
    }
}