/**
 * [LeetCode] 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * 접근 방식
 * 1) 중복 범위 merge를 편하게 하기 위해 주어진 intervals 원소들의 시작 인덱스를 기준으로 오름차순 정렬한다.
 * 2) intervals 원소들의 범위를 순회하면서, 원소 시작 범위가 이전 원소 끝 범위보다 작거나 같다면 최대 범위로 merge 한다.
 */

class Solution {

    static List<List<Integer>> tmp;

    public int[][] merge(int[][] intervals) {
        tmp = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int sIndex = intervals[0][0], eIndex = intervals[0][1];
        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0] <= eIndex) {
                eIndex = Math.max(intervals[i][1], eIndex);
                continue;
            }
            tmp.add(List.of(sIndex, eIndex));
            sIndex = intervals[i][0];
            eIndex = intervals[i][1];
        }
        tmp.add(List.of(sIndex, eIndex));
        int index = 0;
        int[][] result = new int[tmp.size()][2];
        for (List<Integer> t : tmp) {
            result[index][0] = t.get(0);
            result[index][1] = t.get(1);
            index++;
        }
        return result;
    }
}