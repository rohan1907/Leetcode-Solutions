// { Driver Code Starts
//saksham raj seth
import java.util.*;
class Anagrams{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			String s=sc.next();
			String s1=sc.next();
			GfG g=new GfG();
			System.out.println(g.remAnagrams(s,s1));
		}
	}
}// } Driver Code Ends


/*Complete the function below*/
class GfG
{
	public int remAnagrams(String s,String s1)
        {
        //add code here.
        int arr[] = new int[26];
        
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i) - 'a']++;
        }
        for(int i=0;i<s1.length();i++){
            arr[s1.charAt(i) - 'a']--;
        }
        int res= 0;
        for(int ele:arr){
            res+=Math.abs(ele);
        }
        return res;
    }
}