class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        for(int pt1 = 0; pt1 < n; pt1++){
            if(intervals[pt1][0] == -1){
                continue;
            }
            int pt2 = pt1 + 1;
            while(pt2 < n){
                if(intervals[pt1][1] >= intervals[pt2][0]){
                    intervals[pt1][1] = Math.max(intervals[pt2][1], intervals[pt1][1]);
                    intervals[pt2][0] = -1;
                }
                else{
                    break;
                }
                pt2++;
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(intervals[i][0]!=-1){
                list.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            }
        }
        int rows = list.size();
        int cols = 2;
        int arr[][] = new int[rows][2];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                arr[i][j] = list.get(i).get(j);
            }
        }
        return arr;
    }
}