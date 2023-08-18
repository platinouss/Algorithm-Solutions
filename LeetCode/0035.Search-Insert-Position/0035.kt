/**
 * LeetCode
 * 문제 이름 : 35. Search Insert Position
 * 링크 : https://leetcode.com/problems/search-insert-position/
 */

class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var sIndex = 0
        var eIndex = nums.size
        while (sIndex < eIndex) {
            val midIndex = (sIndex + eIndex) / 2
            if (nums[midIndex] < target) {
                sIndex = midIndex + 1
            } else {
                eIndex = midIndex
            }
        }
        return sIndex
    }
}