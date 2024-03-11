import java.util.Stack;

class Solution {
	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;

		Stack<Integer> deliveryStack = new Stack<>();
		Stack<Integer> pickupStack = new Stack<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < deliveries[i]; j++) {
				deliveryStack.push(i + 1);
			}
			for (int j = 0; j < pickups[i]; j++) {
				pickupStack.push(i + 1);
			}
		}

		while (!deliveryStack.empty() && !pickupStack.isEmpty()) {
			int delivery = Math.min(deliveryStack.size(), cap);
			answer += Math.max(deliveryStack.peek(), pickupStack.peek());

			for (int i = 0; i < delivery; i++) {
				popIfNotEmpty(deliveryStack);
			}
			for (int i = 0; i < cap; i++) {
				popIfNotEmpty(pickupStack);
			}
		}

		while (!deliveryStack.empty() || !pickupStack.isEmpty()) {
			if (!deliveryStack.empty()) {
				answer += deliveryStack.peek();
				for (int i = 0; i < cap; i++) {
					popIfNotEmpty(deliveryStack);
				}
			} else if (!pickupStack.empty()) {
				answer += pickupStack.peek();
				for (int i = 0; i < cap; i++) {
					popIfNotEmpty(pickupStack);
				}
			}
		}

		return answer * 2;
	}

	void popIfNotEmpty(Stack<?> stack) {
		if (stack.isEmpty()) {
			return;
		}
        
		stack.pop();
	}
}
