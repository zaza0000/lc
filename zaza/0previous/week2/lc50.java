public class lc50 {
    public double myPow(double x, int n) {
        double ans = 1;
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        if(x == 0)
            return 0;
        if(n == 0)
            return ans;
        double temp = x;
        for( ;N > 0; N /= 2){
            if((N % 2) == 1)
                ans = ans * temp;
            temp = temp * temp;
        }
        return ans;
    }
}
