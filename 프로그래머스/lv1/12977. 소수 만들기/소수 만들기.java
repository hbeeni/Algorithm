class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    boolean isPrime = true;
                    
                    if (num % 2 != 0) {
                        for (int n = 3; n <= Math.sqrt(num); n += 2) {
                            if (num % n == 0) {
                                isPrime = false;
                            }
                        }
                        
                        if (isPrime) {
                            answer++;
                        }
                    }
                }
            }
        }

        return answer;
    }
}