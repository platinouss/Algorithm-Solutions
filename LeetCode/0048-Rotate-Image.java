/**
 * [LeetCode] 48. Rotate Image
 * https://leetcode.com/problems/rotate-image/description/
 *
 * 접근 방식
 * 1) 90도 회전하게 된다면, 기존 배열의 좌표가 (i, j)라고 했을 때, (j, N-1-i)로 swap할 수 있다.
 *  1-1) 여기서 N은 주어진 matrix의 배열 크기를 나타낸다.
 * 2) swap 결과를 담아둘 배열을 만들고, 배열의 모든 인덱스를 1번에 근거하여 swap한다.
 */

class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        int[][] arr = new int[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                arr[j][N - 1 - i] = matrix[i][j];
            }
        }
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                matrix[i][j] = arr[i][j];
            }
        }
    }
}