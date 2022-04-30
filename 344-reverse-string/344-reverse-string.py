class Solution:
    def reverseString(self, s: List[str]) -> None:
        n = len(s)
        i = 0
        while i < n-i-1:
            s[i],s[n-i-1] = s[n-i-1],s[i]
            i += 1
        
        """
        Do not return anything, modify s in-place instead.
        """
        