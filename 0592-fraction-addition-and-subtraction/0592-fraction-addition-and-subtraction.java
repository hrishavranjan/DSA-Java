class Solution {
    public String fractionAddition(String expression) {
        int numerator = 0, denominator = 1;  // Start with 0/1
        
        int i = 0;
        while (i < expression.length()) {
            int sign = 1;  // Handle the sign
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                sign = expression.charAt(i) == '-' ? -1 : 1;
                i++;
            }
            
            // Extract the numerator
            int numStart = i;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                i++;
            }
            int currentNumerator = sign * Integer.parseInt(expression.substring(numStart, i));
            
            i++; // Skip the '/'
            
            // Extract the denominator
            int denomStart = i;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                i++;
            }
            int currentDenominator = Integer.parseInt(expression.substring(denomStart, i));
            
            // Add fractions: a/b + c/d = (a*d + b*c) / (b*d)
            numerator = numerator * currentDenominator + currentNumerator * denominator;
            denominator *= currentDenominator;
            
            // Simplify the fraction by finding the gcd
            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }
        
        return numerator + "/" + denominator;
    }
    
    // Helper function to compute the GCD (Greatest Common Divisor)
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
