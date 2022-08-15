class Solution {
    static Map<Character, Integer> values = new HashMap<>();
    static {
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);
    }

    public int romanToInt(String s) {
        int ans = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (i+1 < n && values.get(s.charAt(i)) < values.get(s.charAt(i+1))) {
				// If current is a small value and next is a bigger value -> It's a combine number
                ans -= values.get(s.charAt(i));
            } else {
                ans += values.get(s.charAt(i));
            }
        }
        return ans;
    }
}