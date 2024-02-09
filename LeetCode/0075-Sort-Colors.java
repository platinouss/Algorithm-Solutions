/**
 * [LeetCode] 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/
 *
 * 접근 방식
 * 1) 주어진 nums 배열을 순회하면서 각 색상별 개수를 카운트하여 저장해둔다.
 * 2) 색상들의 카운트 수에 따라 nums 배열의 원소를 재정의한다.
 */

class Solution {

    int[] colors;

    public void sortColors(int[] nums) {
        colors = new int[3];
        for (int num : nums) {
            colors[num]++;
        }
        int index = 0;
        for (int i=0; i<colors.length; i++) {
            for (int k=0; k<colors[i]; k++) {
                nums[index] = i;
                index++;
            }
        }
    }
}