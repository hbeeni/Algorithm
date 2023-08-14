class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        //index1/2: cards1/2 인덱스
        int index1 = 0;
        int index2 = 0;
        
        /*
        possible: 가능한지 나타내는 변수
        for (i: 0 ~ goal 길이)
            if (index1이 cards1 길이보다 작고, cards1[index1]과 goals[i]가 같으면)
                index1++;
                continue;
            if (index2가 cards2 길이보다 작고, cards2[index2]와 goals[i]가 같으면)
                index2++;
                continue;
            possible = false;
            break;
         */
        boolean possible = true;
        for (int i = 0; i < goal.length; i++) {
            if (index1 < cards1.length && cards1[index1].equals(goal[i])) {
                index1++;
                continue;
            }
            if (index2 < cards2.length && cards2[index2].equals(goal[i])) {
                index2++;
                continue;
            }
            possible = false;
            break;
        }
        
        //possible이 true면 Yes, false면 No
        if (possible) {
            return "Yes";
        } else {
            return "No";
        }
    }
}