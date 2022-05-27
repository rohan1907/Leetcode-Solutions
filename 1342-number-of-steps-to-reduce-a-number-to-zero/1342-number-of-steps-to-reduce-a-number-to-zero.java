class Solution {
    public int numberOfSteps (int num) {
        int cnt = 0;
        while (num > 0) {
            cnt += num % 2 == 0 || num == 1 ? 1 : 2;
            num /= 2;
        }
        return cnt;
    }
}