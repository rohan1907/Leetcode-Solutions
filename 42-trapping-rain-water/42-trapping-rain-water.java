class Solution {
    public int trap(int[] height) {
        
        int len = height.length;
        if(len<=2) return 0; 
        int inc[] = new int[len];
        int dec[] = new int[len];
        inc[0] = height[0];
        dec[len-1] = height[len-1];
        int maxinc=inc[0];
        for(int i=1;i<len-1;i++){
            if(height[i]<maxinc) inc[i] = maxinc-height[i];
            else 
                maxinc = height[i];
        }
        int maxdec=dec[len-1];
        for(int i=len-2;i>0;i--){
            if(height[i]<maxdec) dec[i] = maxdec-height[i];
            else maxdec = height[i];
        }
        int res=0;
        for(int i=0;i<len;i++){
            res+=Math.min(inc[i],dec[i]);
        }
        return res;
    }
}