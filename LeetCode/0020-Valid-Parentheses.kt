/**
 * LeetCode
 * 문제 이름 : 20. Valid Parentheses
 * 링크 : https://leetcode.com/problems/valid-parentheses/
 */

class Solution {

    val deque = ArrayDeque<Char>()

    fun setChar(ch: Char): Boolean {
        if (ch == '(' || ch == '[' || ch == '{') {
            deque.addLast(ch)
        } else {
            if (ch == ')' && deque.lastOrNull() == '(') deque.removeLast()
            else if (ch == '}' && deque.lastOrNull() == '{') deque.removeLast()
            else if (ch == ']' && deque.lastOrNull() == '[') deque.removeLast()
            else return false
        }
        return true
    }

    fun isValid(s: String): Boolean {
        for (i in s.indices) {
            if (!setChar(s[i])) {
                return false
            }
        }
        return deque.size == 0
    }
}