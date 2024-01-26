/**
 * [LeetCode] 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * 접근 방식
 * 1) 최댓값을 저장할 max와 합을 저장할 sum을 선언 후, 주어진 nums 배열을 순회하면서 sum 값에 순회한 원소를 더한다.
 * 2) 이때 sum이 0보다 작다는 것은, (sum + 다음 원소) 값이 다음 원소 값 보다 작다는 것이므로 sum을 0으로 갱신한다.
 * 3) max 값을 반환한다.
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int max = -10001;
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
