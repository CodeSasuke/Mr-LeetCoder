class Solution {
    public int countPrimes(int n) {
        int res = 0;
        // List<Integer> list = new ArrayList<>();
        int[] primes = new int[n];
        Arrays.fill(primes,1);
        for(int i = 2; i * i < n; i++){
            if(primes[i] == 1){
                for(int j = i * i; j < n;j+=i){
                    primes[j] = 0;
                }
            }
        }
        for(int i = 2; i < n; i++){
            if(primes[i] == 1) {
                // list.add(i);
                res++;
            }
        }
        return res;
    }
}