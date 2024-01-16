class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) { return false; }
        
        int reverseNum = 0;
        int tmp = x;
        while (tmp != 0) {
            reverseNum = reverseNum*10 + tmp%10;
            tmp /= 10;
        }
        
        return reverseNum == x;
    }
}