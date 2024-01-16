/**
 * LeetCode
 * 문제 이름 : 27. Remove Element
 * 링크 : https://leetcode.com/problems/remove-element/
 */

class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var index = if (nums.size > 0 && nums[0] != `val`) 1 else 0
        for (i in 1 until nums.size) {
            if (nums[i] == `val`) continue
            nums[index] = nums[i]
            index++
        }
        return index
    }
}