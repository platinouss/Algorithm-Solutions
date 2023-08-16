/**
 * LeetCode
 * 문제 이름 : 26. Remove Duplicates from Sorted Array
 * 링크 : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var cnt = if (nums.size > 0) 1 else 0
        for (i in 1 until nums.size) {
            if (nums[i] == nums[i-1]) continue
            nums[cnt] = nums[i]
            cnt++
        }
        return cnt
    }
}