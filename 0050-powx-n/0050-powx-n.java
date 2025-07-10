class Solution {
    public double myPow(double x, int n) {
        // Promote to long to safely handle Integer.MIN_VALUE
        long N = n;
        if (N < 0) {
            return 1.0 / power(x, -N);
        }
        return power(x, N);
    }

    private double power(double x, long n) {
        if (n == 0) return 1.0;
        if(n % 2 == 0){
            return power(x*x,n/2);
        }
        if(n % 2 == 1){
            return x * power(x,n-1);
        }
        return 0;
    }
}