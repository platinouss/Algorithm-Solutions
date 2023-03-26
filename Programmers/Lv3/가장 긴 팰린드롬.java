/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 가장 긴 팰린드롬 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12904
 */

class Solution {

    static int max = 0;
    static boolean isEven = false;

    public int solution(String s) {
        if (s.length() % 2 == 0) {
            isEven = true;
        }
        for (int i=0; i<s.length(); i++) {
            isPalindrome(i, i, s);
        }
        for (int i=0; i<s.length() - 1; i++) {
            isPalindrome(i, i+1, s);
        }
        return max;
    }

    private static void isPalindrome(int sIndex, int eIndex, String s) {
        int count = 0;
        while (sIndex >= 0 && eIndex < s.length()) {
            if (s.charAt(sIndex) != s.charAt(eIndex)) {
                break;
            }
            count++;
            if (sIndex != eIndex) {
                count++;
            }
            sIndex = sIndex - 1;
            eIndex = eIndex + 1;
        }
        max = Math.max(max, count);
    }
}