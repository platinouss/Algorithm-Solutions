/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : N개의 최소공배수 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12953
 */

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i=1; i<arr.length; i++) {
            int gcd = gcd(answer, arr[i]);
            answer = answer * arr[i] / gcd;
        }

        return answer;
    }

    private static int gcd(int a, int b) {
        int x = Math.max(a, b);
        int y = Math.min(a, b);

        while (x % y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }

        return y;
    }
}