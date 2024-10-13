import java.util.*;

class Solution {
    private static final int MOD = 1000000007;

    // Function to calculate x^y % MOD in O(log y) time using binary exponentiation
    private long modPow(long x, long y) {
        long res = 1;
        while (y > 0) {
            if (y % 2 == 1) {
                res = (res * x) % MOD;
            }
            x = (x * x) % MOD;
            y /= 2;
        }
        return res;
    }

    // Function to compute Stirling Numbers of the Second Kind S(n, k)
    private long[][] stirlingNumbers(int n, int k) {
        long[][] S = new long[n + 1][k + 1];
        S[0][0] = 1;  // Base case
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                S[i][j] = (S[i - 1][j - 1] + (j * S[i - 1][j]) % MOD) % MOD;
            }
        }
        return S;
    }

    public int numberOfWays(int n, int x, int y) {
        // Compute all Stirling numbers of the second kind S(n, k) for k up to n
        long[][] S = stirlingNumbers(n, x);

        long total = 0;

        // Loop over each possible number of non-empty stages (k)
        for (int k = 1; k <= Math.min(n, x); k++) {
            // S(n, k)
            long stirling = S[n][k];

            // P(x, k) = x! / (x-k)!
            long P = 1;
            for (int i = 0; i < k; i++) {
                P = (P * (x - i)) % MOD;
            }

            // y^k
            long scoreCombinations = modPow(y, k);

            // Add contribution of this k to total
            total = (total + stirling * P % MOD * scoreCombinations % MOD) % MOD;
        }

        return (int) total;
    }
}
