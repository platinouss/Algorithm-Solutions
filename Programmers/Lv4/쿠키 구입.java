/**
 * [프로그래머스] Lv4. 쿠키 구입
 * https://school.programmers.co.kr/learn/courses/30/lessons/49995
 *
 */

class Solution {
    public int solution(int[] cookie) {
        int N = cookie.length;
        if (N == 1) {
            return 0;
        }
        int max = 0;
        for (int mid=0; mid<N-1; mid++) {
            int left = mid, right = mid+1;
            int leftSum = cookie[left], rightSum = cookie[right];
            while (true) {
                if (leftSum == rightSum) {
                    max = Math.max(max, rightSum);
                }
                if (left > 0 && leftSum <= rightSum) {
                    left--;
                    leftSum += cookie[left];
                } else if (right < N - 1 && leftSum > rightSum) {
                    right++;
                    rightSum += cookie[right];
                } else {
                    break;
                }
            }
        }
        return max;
    }
}