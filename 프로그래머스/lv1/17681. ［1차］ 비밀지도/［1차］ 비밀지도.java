class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            String binary1 = Integer.toBinaryString(arr1[i]);
            String binary2 = Integer.toBinaryString(arr2[i]);

            binary1 = "0".repeat(n - binary1.length()) + binary1;
            binary2 = "0".repeat(n - binary2.length()) + binary2;
            
            String result = "";
            
            //둘 다 0이면 "", 나머지는 "#"
            for (int j = 0; j < n; j++) {
                if (binary1.charAt(j) == '0' && binary2.charAt(j) == '0') {
                    result += " ";
                } else {
                    result += "#";
                }
            }
            
            answer[i] = result;
        }
        
        return answer;
    }
}