/**
 * [LeetCode] 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/
 *
 * 접근 방식
 * 1) i=0인 부분과 j=0인 부분은 갈 수 있는 경우의 수가 한 번밖에 없기 때문에 모두 1로 채운다.
 * 2) (1, 1)부터 (N-1, M-1)까지 routes[i][j] = routes[i-1][j] + routes[i][j-1]로 채운다.
 * 3) routes[N-1][M-1] 값을 반환한다.
 */

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] routes = new int[m][n];
        for (int j=0; j<n; j++) {
            routes[0][j] = 1;
        }
        for (int i=0; i<m; i++) {
            routes[i][0] = 1;
        }
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                routes[i][j] = routes[i-1][j] + routes[i][j-1];
            }
        }
        return routes[m-1][n-1];
    }
}
