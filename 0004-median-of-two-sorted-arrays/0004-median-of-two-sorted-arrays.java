class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] arr = new int[m + n];
        int left = 0, right = 0, k = 0;

        // Merge nums1 and nums2 into arr
        while (left < m && right < n) {
            if (nums1[left] < nums2[right]) {
                arr[k++] = nums1[left++];
            } else {
                arr[k++] = nums2[right++];
            }
        }
        while (left < m) {
            arr[k++] = nums1[left++];
        }
        while (right < n) {
            arr[k++] = nums2[right++];
        }

        // Calculate the median
        int totalLength = m + n;
        if (totalLength % 2 == 0) {
            return (arr[totalLength / 2 - 1] + arr[totalLength / 2]) / 2.0;
        } else {
            return arr[totalLength / 2];
        }
    }
}
