/**
 * [LeetCode] 61. Rotate List
 * https://leetcode.com/problems/rotate-list/
 *
 * 접근 방식
 * 1) 주어진 head를 순회하여 LinkedList 개수를 카운트하고 변수 N에 저장한다. 또한 가장 마지막에 있는 LinkedList를 tail에 저장한다.
 * 2) head가 null이거나, k % N이 0이라면 head를 반환한다.
 * 3) N - (K % N) 위치에 있는 LinkedList를 마지막 LinkedList로 설정하고, 그 뒤에 있는 LinkedList를 가장 앞으로 이동시킨 후 연결한다.
 * 4) 가장 앞에 있는 LinkedList를 반환한다.
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    private int N;
    private ListNode tail;

    private int getCount(ListNode head) {
        int count = 0;
        while (head != null) {
            tail = head;
            head = head.next;
            count++;
        }
        return count;
    }

    private ListNode rotate(ListNode head, int k) {
        ListNode target = head;
        for (int i=1; i<N-k; i++) {
            target = target.next;
        }
        ListNode first = target.next;
        target.next = null;
        tail.next = head;
        if (first == null) {
            return target;
        }
        return first;
    }

    public ListNode rotateRight(ListNode head, int k) {
        N = getCount(head);
        if (N == 0 || k % N == 0) {
            return head;
        }
        return rotate(head, k % N);
    }
}
