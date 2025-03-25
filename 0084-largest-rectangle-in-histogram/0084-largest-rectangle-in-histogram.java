class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n == 0){
            return 0;
        }
        int pse[] = new int[n];
        int nse[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        // first compute pse
        for(int i = 0; i < n; i++){
            if(i == 0){
                pse[i] = -1; 
            }
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                pse[i] = -1;
            }
            else{
                pse[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        // now compute nse
        for(int i = n-1; i >= 0; i--){
            if(i == n){
                nse[i] = n; 
            }
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nse[i] = n;
            }
            else{
                nse[i] = stack.peek();
            }
            stack.push(i);
        }
        int area = 0;
        for(int i = 0; i < n; i++){
            int curr = heights[i] * (nse[i] - pse[i] - 1);
            area = Math.max(area,curr);
        }
        return area;
    }
}