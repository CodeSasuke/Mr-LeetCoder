class Solution {
  public int largestRectangleArea(int[] heights) {
    int n = heights.length;
    if(n == 1){
        return heights[0];
    }
    int[] nse = new int[n];
    int[] pse = new int[n];
    Stack < Integer > stack = new Stack < > ();
    // nse
    for (int i = n-1; i >= 0; i--) {
      while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
        stack.pop();
      }
      nse[i] = stack.isEmpty() ? n : stack.peek();
      stack.push(i);
    }
    // pge
    stack.clear();
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
        stack.pop();
      }
      pse[i] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(i);
    }
    int maxArea = 0;
    for(int i = 0; i < n; i++){
        int area = heights[i] *  (nse[i] - pse[i] - 1);
        // int area = Math.max(left,right);
        // System.out.printf("The index is %d, the pse is %d , nse is %d and the area is %d\n", i, pse[i], nse[i], area);

        area = Math.abs(area);
        maxArea = Math.max(area,maxArea);
    }
    return maxArea;
  }
}