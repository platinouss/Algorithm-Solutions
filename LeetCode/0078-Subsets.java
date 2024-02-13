/**
 * [LeetCode] 18. Subsets
 * https://leetcode.com/problems/subsets/description/
 *
 * 접근 방식
 * 1) 백트래킹으로 해결하되, 백트래킹 시작지점에서 현재 원소를 result에 추가한다.
 * 2) result를 반환한다.
 */

class Solution {

    List<List<Integer>> result;

    private void combination(List<Integer> list, int depth, int index, int[] nums) {
        result.add(new ArrayList<>(list));
        for (int i=index; i<nums.length; i++) {
            list.add(nums[i]);
            combination(list, depth + 1, i+1, nums);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        combination(new ArrayList<>(), 0, 0, nums);
        return result;
    }
}