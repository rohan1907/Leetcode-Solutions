class Solution {
    public String removeKdigits(String num, int k) {
        //increasing stack, if meet num < peek, so pop it, we remove larger num in high digit
        //use array to mock the stack, they are same to add num at end,and remove
        //corner case
        if(num.length() == 0 || num == null)
            return num;
        int len = num.length();
         int remainingDigit = len -k;
        //create char array mock stck
        char[] stk = new char[len];
        int top =0;  //last element
        for(int i = 0;i<len;i++){
            char c = num.charAt(i);
            while(top>0 && k> 0 && c < stk[top-1]){
                //cur char < peek element
                top--;  //remove top
                k--;
            }
            stk[top++] = c;
        }
        //find first elemtn != 0
        int index =0;
       
        while(index < remainingDigit && stk[index] == '0'){
            index++;
        }
        //if index == remianiD -> whole string all 0
        return index == remainingDigit ? "0" : new String(stk,index,remainingDigit - index);
        
    }
}