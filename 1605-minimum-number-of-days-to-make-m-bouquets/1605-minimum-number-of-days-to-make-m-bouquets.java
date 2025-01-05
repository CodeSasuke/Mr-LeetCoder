class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < m * k) {
            return -1;
        }
        int lo = Arrays.stream(bloomDay).min().getAsInt();
        int hi = Arrays.stream(bloomDay).max().getAsInt();
        int ans = -1;
        while (lo <= hi) {
            int groups = 0;
            int mid = lo + (hi - lo) / 2;
            int index = 0;
            while (index < n) {
                int count = 0;
                while (index < n) {
                    if (bloomDay[index] <= mid) 
                    {
                        count++;
                        index++;
                    } 
                    
                    else {
                        index++;
                        break;
                    }
                }
                groups += (count) / k;
            }
            if(groups >= m){
                ans = mid;
                hi = mid-1;
            }
            else{
                lo = mid + 1;
            }
        }
        return ans;
    }
}