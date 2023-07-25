class Solution {
    public int solution(int n) {
        int countOne1 = Integer.toBinaryString(n)
                .replace("0", "").length();
        n++;
        
        while (true) {
            int countOne2 = Integer.toBinaryString(n)
                    .replace("0", "").length();

            if (countOne1 == countOne2) {
                break;
            }
            n++;
        }
        
        return n;
    }
}