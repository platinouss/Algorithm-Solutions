/**
 * LeetCode
 * 문제 이름 : 21. Merge Two Sorted Lists
 * 링크 : https://leetcode.com/problems/merge-two-sorted-lists/
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? = when {
        list1 == null -> list2
        list2 == null -> list1
        list1.`val` < list2.`val` -> list1.apply { next = mergeTwoLists(list1.next, list2) }
        else -> list2.apply { next = mergeTwoLists(list1, list2.next) }
    }
}