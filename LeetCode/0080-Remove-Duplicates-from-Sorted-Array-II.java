/**
 * [LeetCode] 80. Remove Duplicates from Sorted Array II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 *
 * 접근 방식
 * 1) prev와 current를 선언한다.
 * 2) 문제에서 연속된 숫자의 개수가 2 초과가 되면 삭제시켜줘야 하므로, 이때는 current만 증가시켜 지워질 수 수의 범위를 늘린다.
 * 3) 2번 조건이 성립되지 않을 때는 prev 인덱스를 증가 시켜주고, prev 인덱스에 current 인덱스 값을 대입시켜준다.
 *    이후 current를 증가시킨다.
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = 1;
        int current = 2;
        while (current < nums.length) {
            if (nums[current] == nums[prev - 1] && nums[current] == nums[prev]) {
                current++;
            } else {
                prev++;
                nums[prev] = nums[current];
                current++;
            }
        }
        return prev + 1;
    }
}
