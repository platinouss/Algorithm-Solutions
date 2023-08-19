/**
 * LeetCode
 * 문제 이름 : 66. Plus One
 * 링크 : https://leetcode.com/problems/plus-one/
 */

class Solution {
    fun plusOne(digits: IntArray): IntArray {
        if (digits.last() < 9) {
            digits[digits.lastIndex] = digits.last() + 1
            return digits
        }
        for (i in digits.lastIndex downTo 0) {
            digits[i]++
            if (digits[i] == 10) digits[i] = 0 else return digits
        }
        return intArrayOf(1, *digits)
    }
}
