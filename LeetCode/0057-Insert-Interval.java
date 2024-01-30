/**
 * [LeetCode] 56. Insert Interval
 * https://leetcode.com/problems/insert-interval/
 *
 * 접근 방식
 * 1) 주어진 intervals는 겹치는 구간이 없기 때문에, intervals의 끝점이 newInterval의 시작점보다 작다면 result에 지속적으로 추가한다.
 * 2) intervals가 아직 남았다면 현 시점의 intervals는 newInterval과 범위가 겹친다는 뜻이므로,
 *    intervals 시작점이 newInterval의 끝점보다 작거나 같을 때까지 병합해준다.
 * 3) 남은 intervals를 result에 추가해준다.
 */

class Solution {

    List<int[]> result;

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int index = 0;
        result = new ArrayList<>();
        while (index < intervals.length && intervals[index][1] < newInterval[0]) {
            result.add(new int[]{intervals[index][0], intervals[index][1]});
            index++;
        }
        while (index < intervals.length && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }
        result.add(new int[]{newInterval[0], newInterval[1]});
        while (index < intervals.length) {
            result.add(new int[]{intervals[index][0], intervals[index][1]});
            index++;
        }
        return result.toArray(new int[result.size()][2]);
    }
}
