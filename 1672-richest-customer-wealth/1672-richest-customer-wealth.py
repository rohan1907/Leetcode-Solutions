class Solution:
    def maximumWealth(self, accounts: List[List[int]]) -> int:
        m, n = len(accounts), len(accounts[0])
        maxSum = 0
        for i in range(m):
            maxSum = max(maxSum, sum(accounts[i]))
        return maxSum