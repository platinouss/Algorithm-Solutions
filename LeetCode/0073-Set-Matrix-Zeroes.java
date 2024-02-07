/**
 * [LeetCode] 73. Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 *
 * 접근 방식
 * 1) matrix를 순회하면서 해당 원소 값이 0일 때, row 인덱스와 column 인덱스를 따로 저장해둔다.
 * 2) 저장해둔 row 인덱스와 column 인덱스들을 순회하면서, 해당 row(또는 column)의 원소들을 0으로 치환한다.
 */

class Solution {

    List<Integer> rows;
    List<Integer> columns;

    public void setZeroes(int[][] matrix) {
        rows = new ArrayList<>();
        columns = new ArrayList<>();
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        for (int rowIndex : rows) {
            for (int j=0; j<matrix[0].length; j++) {
                matrix[rowIndex][j] = 0;
            }
        }
        for (int columnIndex : columns) {
            for (int i=0; i<matrix.length; i++) {
                matrix[i][columnIndex] = 0;
            }
        }
    }
}