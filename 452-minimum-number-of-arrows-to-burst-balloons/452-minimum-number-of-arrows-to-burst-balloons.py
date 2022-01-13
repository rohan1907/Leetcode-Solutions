class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        ret, shoot = 0, float('inf')
        for s, e in sorted(points, reverse=True):
            if shoot > e:
                shoot = s
                ret += 1
        return ret