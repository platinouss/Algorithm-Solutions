/**
 * LeetCode
 * 문제 이름 : 28. Find the Index of the First Occurrence in a String
 * 링크 : https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 */

class Solution {
    fun isEqualString(idx: Int, haystack: String, needle: String): Boolean {
        var index = idx
        for (ch in needle) {
            if (ch != haystack[index]) return false
            index++
        }
        return true
    }

    fun strStr(haystack: String, needle: String): Int {
        var index = 0
        while (index < haystack.length) {
            if (index + needle.length > haystack.length) break
            if (isEqualString(index, haystack, needle)) return index
            index++
        }
        return -1
    }
}