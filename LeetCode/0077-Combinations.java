/**
 * [LeetCode] 77. Combinations
 * https://leetcode.com/problems/combinations/description/
 *
 * 접근 방식
 * 1) 중복 결과를 제외해야 하므로 시작 index를 인자로 넘겨 백트래킹으로 해결했다.
 */


class Solution {

    List<List<Integer>> result;

    private void combination(int depth, int index, List<Integer> list, int n, int k) {
        if (depth == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=index; i<=n; i++) {
            list.add(i);
            combination(depth + 1, i + 1, list, n, k);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        combination(0, 1, new ArrayList<>(), n, k);
        return result;
    }
}