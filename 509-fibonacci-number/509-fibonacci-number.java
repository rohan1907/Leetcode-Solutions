class Solution {
    public int fib(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        int fib1 =0, fib2 = 1;
        for(int i=2;i<=n;i++){
            int sum = fib1+fib2;
            fib1 = fib2;
            fib2 = sum;
        }
        return fib2;
    }
}