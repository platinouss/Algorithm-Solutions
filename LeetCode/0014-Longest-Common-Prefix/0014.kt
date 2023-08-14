/**
 * LeetCode
 * 문제 이름 : 14. Longest Common Prefix
 * 링크 : https://leetcode.com/problems/longest-common-prefix/
 */

import kotlin.math.*;

class Solution {
    fun compareString(str1: String, str2: String): String {
        var str: String = ""
        for (i in 0..min(str1.length, str2.length)-1) {
            if (str1[i] != str2[i]) {
                return str
            }
            str += str1[i]
        }
        return str
    }

    fun longestCommonPrefix(strs: Array<String>): String {
        var tmp: String = strs.get(0)
        for (i in 1..strs.size-1) {
            tmp = compareString(tmp, strs.get(i))
        }
        return tmp
    }
}