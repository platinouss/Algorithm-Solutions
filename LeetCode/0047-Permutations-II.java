/**
 * [LeetCode] 47. Permutations II
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * 접근 방식
 * 1) 고유한 순열을 편하게 뽑기 위해서, 주어진 nums 배열을 정렬시킨다.
 * 2) 백트래킹을 활용하여 순열을 구하되, 고유한 순열을 뽑아야 하기 때문에
 *    해당 뎁스 내에서 이전에 어떤 값으로 백트래킹을 진행했는지 before 변수에 값을 저장한다.
 *  2-1) 백트래킹을 진행하려는 원소와 before 값이 같다면, 동일한 뎁스 내에서 해당 값으로 백트래킹을 진행했다는 뜻이므로 건너뛴다.
 * 3) 중복 원소로 순열 구성하는 것을 방지하기 위해 비트 마스킹으로 체크한다.
 */

class Solution {

    private List<List<Integer>> result;

    private void permutation(List<Integer> list, int depth, int bitmask, int[] nums) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        int before = -11;
        for (int i=0; i<nums.length; i++) {
            if (before == nums[i] || (bitmask & (1 << i)) > 0) {
                continue;
            }
            before = nums[i];
            list.add(nums[i]);
            permutation(list, depth + 1, bitmask | (1 << i), nums);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        permutation(new ArrayList<>(), 0, 0, nums);
        return result;
    }
}