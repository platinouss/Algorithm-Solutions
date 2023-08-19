/**
 * LeetCode
 * 문제 이름 : 58. Length of Last Word
 * 링크 : https://leetcode.com/problems/length-of-last-word/
 */

class Solution {
    fun lengthOfLastWord(s: String): Int {
        var str = s.trim()
        return str.split(" ").let { it[it.size - 1].length }
    }
}