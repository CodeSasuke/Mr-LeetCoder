class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            // Assume no discount initially
            answer[i] = prices[i];
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    // Apply the discount and stop further checks
                    answer[i] = prices[i] - prices[j];
                    break;
                }
            }
        }

        return answer;
    }
}
