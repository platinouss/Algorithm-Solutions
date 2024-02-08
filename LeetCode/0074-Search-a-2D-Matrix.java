/**
 * [LeetCode] 74. Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 *
 * 접근 방식
 * 1) target 값이 있는 행 위치를 찾기 위해, matrix의 행 순서대로 찾는다.
 *    이때 해당 행의 시작 원소 값을 최솟값, 마지막 원소 값을 최댓 값으로 하는 범위 내에 target이 위치하는지 확인한다.
 *    만약 위치할 수 있다면 해당 행을 기준으로 2번을 진행한다.
 * 2) 해당 행의 원소들을 이진 탐색으로 탐색하여, target 값과 동일한 값이 존재하는지 확인한다.
 *    만약 있다면 true를 반환한다.
 */

class Solution {

    int N, M;

    private boolean binarySearch(int[] arr, int target) {
        int sIndex = 0;
        int eIndex = M - 1;
        while (sIndex < eIndex) {
            int mid = (sIndex + eIndex) / 2;
            if (arr[mid] < target) {
                sIndex = mid + 1;
            } else {
                eIndex = mid;
            }
        }
        if (arr[sIndex] == target) {
            return true;
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        N = matrix.length;
        M = matrix[0].length;
        for (int i=0; i<N; i++) {
            int start = matrix[i][0];
            int end = matrix[i][M - 1];
            if (target < start) {
                return false;
            }
            if (start <= target && target <= end) {
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }
}