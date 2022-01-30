class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        n = len(nums)
        if k==n:
            return nums
        k = k%n
        i, j = n-k,n-1
        while i<=j:
            nums[i], nums[j] = nums[j], nums[i]
            i+=1
            j-=1
        i, j = 0,n-k-1
        while i<=j:
            nums[i], nums[j] = nums[j], nums[i]
            i+=1
            j-=1
        i,j=0,n-1
        while i<=j:
            nums[i], nums[j] = nums[j], nums[i]
            i+=1
            j-=1
        return nums
        """
        Do not return anything, modify nums in-place instead.
        """
        