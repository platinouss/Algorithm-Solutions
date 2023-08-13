/**
 * LeetCode
 * 문제 이름 : 13. Roman to Integer
 * 링크 : https://leetcode.com/problems/roman-to-integer/
 */

class Solution {
    fun getScore(symbol: Char): Int {
        return when(symbol) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> 0
        }
    }

    fun romanToInt(s: String): Int {
        var index: Int = 0
        var score: Int = 0
        while (index < s.length) {
            var value1: Int = getScore(s[index])
            if (index + 1 < s.length) {
                val value2: Int = getScore(s[index + 1])
                if (value2 > value1) {
                    value1 = value2 - value1
                    index += 1
                }
            }
            score += value1
            index += 1
        }
        return score
    }
}