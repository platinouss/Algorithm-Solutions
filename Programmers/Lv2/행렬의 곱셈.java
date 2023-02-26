/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 행렬의 곱셈 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12949
 */

class Solution {
    private static int getResult(int i, int j, int[][] arr1, int[][] arr2) {
        int result = 0;
        int index = 0;
        for (int k=0; k<arr1[i].length; k++) {
            result += (arr1[i][k] * arr2[k][j]);
        }

        return result;
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int N = arr1.length;
        int M = arr2[0].length;
        int[][] answer = new int[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                answer[i][j] = getResult(i, j, arr1, arr2);
            }
        }

        return answer;
    }
}