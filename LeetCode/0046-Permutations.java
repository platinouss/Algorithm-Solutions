/**
 * [LeetCode] 46. Permutations
 * https://leetcode.com/problems/permutations/description/
 *
 * 접근 방식
 * 1) 백트래킹을 활용하여 간단하게 순열을 구할 수 있었다.
 */

class Solution {

    static List<List<Integer>> result;

    private void permutation(List<Integer> list, int depth, int bitmask, int[] nums) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if ((bitmask & (1 << i)) > 0) {
                continue;
            }
            list.add(nums[i]);
            permutation(list, depth + 1, bitmask | (1 << i), nums);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        permutation(new ArrayList<>(), 0, 0, nums);
        return result;
    }
}