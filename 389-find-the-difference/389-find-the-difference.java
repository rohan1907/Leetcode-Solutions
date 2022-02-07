class Solution {
    public char findTheDifference(String s, String t) {
        if(s.length() == 0) return t.charAt(0);
        int arr[] = new int[26];
        
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }
        
        arr[t.charAt(t.length()-1)-'a']--;
        
        int i;
        for(i=0;i<26;i++){
            if(arr[i]!=0) break;
        }
        
        return (char) (i+'a');
    }
    
}