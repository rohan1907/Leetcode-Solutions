class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0;
        int end = nums.length - 1;
        k = nums.length - k;
        while (end - start > 5) {
            int pivot = medianOf3(nums, start, end);
            int i = start;
            int j = end - 1;
            while (true) {
                do {
                    i++;
                } while (nums[i] < pivot);
                do {
                    j--;
                } while (nums[j] > pivot);
                if (i < j) {
                    swap(nums, i, j);
                } else {
                    break;
                }
            }
            swap(nums, i, end - 1);
            if (i == k) {
                return nums[i];
            } else if (i < k) {
                start = i + 1;
            } else {
                end = i - 1;
            }
        }
        for (int i = start + 1; i <= end; i++) {
            for (int j = i - 1; j >= start; j--) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                } else {
                    break;
                }
            }
        }
        return nums[k];
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private int medianOf3(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        if (nums[start] > nums[mid]) {
            swap(nums, start, mid);
        }
        if (nums[mid] > nums[end]) {
            swap(nums, mid, end);
        }
        if (nums[start] > nums[mid]) {
            swap(nums, start, mid);
        }
        swap(nums, mid, end - 1);
        return nums[end - 1];
    }
}
