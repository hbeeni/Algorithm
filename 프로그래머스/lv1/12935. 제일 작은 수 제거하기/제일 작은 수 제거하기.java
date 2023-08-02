class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }
        
        int[] answer = new int[arr.length - 1];

        int min = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[min] > arr[i]) {
                min = i;
            }
        }

        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != min) {
                answer[idx++] = arr[i];
            }
        }
        
        return answer;
    }
}