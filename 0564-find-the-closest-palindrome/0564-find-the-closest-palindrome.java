class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        long num = Long.parseLong(n);
        
        // Edge cases for smallest and largest possible palindrome
        long smallerPalindrome = (long) Math.pow(10, len - 1) - 1; // 999...9
        long largerPalindrome = (long) Math.pow(10, len) + 1;      // 100...001
        
        // Palindrome by mirroring the first half
        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        long[] candidates = new long[]{
            mirror(prefix - 1, len),
            mirror(prefix, len),
            mirror(prefix + 1, len),
            smallerPalindrome,
            largerPalindrome
        };
        
        long closest = -1;
        for (long candidate : candidates) {
            if (candidate != num && (closest == -1 ||
                Math.abs(candidate - num) < Math.abs(closest - num) ||
                (Math.abs(candidate - num) == Math.abs(closest - num) && candidate < closest))) {
                closest = candidate;
            }
        }
        
        return String.valueOf(closest);
    }
    
    // Helper function to generate a palindrome by mirroring the first half
    private long mirror(long prefix, int length) {
        String strPrefix = String.valueOf(prefix);
        StringBuilder sb = new StringBuilder(strPrefix);
        String mirrored = sb.reverse().toString();
        return Long.parseLong(strPrefix + mirrored.substring(length % 2));
    }
}
