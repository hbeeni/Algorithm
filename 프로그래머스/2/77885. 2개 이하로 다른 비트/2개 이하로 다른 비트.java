class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i] + 1;
            int count = 0;
            while (number % 2 == 0) {
                count++;
                number /= 2;
            }
            answer[i] = numbers[i] + (long) Math.pow(2, Math.max(count - 1, 0));
        }
        return answer;
    }
}