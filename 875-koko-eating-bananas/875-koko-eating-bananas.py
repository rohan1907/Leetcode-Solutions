class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        low, high = 1, max(piles)
        while low < high:
            mid = (low+high) //2
            hspent = 0
            
            
            for pile in piles:
                hspent += math.ceil(pile/mid)
            if hspent <= h:
                high = mid
            else:
                low = mid + 1
                
        return high