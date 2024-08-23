class Solution {

    public int reverse(int n) {

        int ans = 0;
        
        //while N is not 0, get the last digit and add it to ans while checking that the current value does not overflow
        while(n != 0){

            //last digit
            int d = n%10;
            //chop off the last digit from N
            n = n/10;

            //if the current ans is more than MAX/10 or current ans is equal to MAX && last digit is more than the digit in MAX_VALUE, return 0
            //similarly for min value
            if(ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && d > Integer.MAX_VALUE%10)) return 0;
            if(ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE/10 && d < Integer.MIN_VALUE%10)) return 0;

            ans = (ans * 10) + d;

        }

        return ans;

    }

}