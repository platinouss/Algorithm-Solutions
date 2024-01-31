/**
 * [LeetCode] 59. Spiral Matrix II
 * https://leetcode.com/problems/spiral-matrix-ii/
 *
 * 접근 방식
 * 1) 반환할 배열 arr를 선언하고, 다음과 같은 규칙으로 1씩 증가하는 값을 추가한다.
 * 2) 하/좌 각각 n-1번 탐색 -> 상/우 각각 n-2번 탐색 -> 하/좌 각각 n-3번 탐색과 같은 규칙성을 띄므로
 *    하/좌 탐색, 상/우 탐색 함수를 만들어 n이 0이 될때까지 1씩 증가하는 값을 해당 위치에 추가하며 진행한다.
 *  2-1) 이때, 2번과 같은 규칙성으로 탐색하기 위해 가장 처음에 우로 n번 탐색한다.
 * 3) arr 배열을 반환한다.
 */

class Solution {

    private int a, b, num;
    private int[][] arr;
    private int[] di = {1, 0, -1, 0};
    private int[] dj = {0, -1, 0, 1};

    private void movePointer(int k, int count) {
        for (int depth = 0; depth < count; depth++) {
            a += di[k];
            b += dj[k];
            arr[a][b] = ++num;
        }
    }

    private void bottomLeftSearch(int count) {
        movePointer(0, count);
        movePointer(1, count);
    }

    private void topRightSearch(int count) {
        movePointer(2, count);
        movePointer(3, count);
    }

    public int[][] generateMatrix(int n) {
        a = 0;
        b = -1;
        num = 0;
        arr = new int[n][n];
        movePointer(3, n);
        n--;
        while (n > 0) {
            bottomLeftSearch(n--);
            if (n <= 0) {
                break;
            }
            topRightSearch(n--);
        }
        return arr;
    }
}