/**
 * [LeetCode] 55. Jump Game
 * https://leetcode.com/problems/jump-game/description/
 *
 * 접근 방식
 * 1) 주어진 nums 배열을 순회하면서, 최대한으로 갈 수 있는 거리(max)를 계산한다.
 *  1-1) 이때 최대한으로 갈 수 있는 거리(max)가 탐색 인덱스보다 작을 경우 갈 수 없는 곳이라고 판단하여 false를 반환한다.
 * 2) nums 배열을 모두 탐색했다면 true를 반환한다.
 */

class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i=0; i<nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}