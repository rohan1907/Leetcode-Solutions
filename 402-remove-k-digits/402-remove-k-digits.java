class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<n;i++){
            char c = num.charAt(i);
            while(!st.isEmpty() && k>0 && st.peek()>c){
                st.pop();
                k--;
            }
            if(!st.isEmpty() || c!='0')
                st.push(c);
        }
        
        while(!st.isEmpty() && k-- >0)
            st.pop();
        if(st.isEmpty())
            return "0";
        
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()){
            str.append(st.pop().toString());
        }
        return str.reverse().toString();
    }
}