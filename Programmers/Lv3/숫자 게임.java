/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 숫자 게임 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12987
 */

import java.util.*;

class Solution {

    static boolean[] visited;

    public int solution(int[] A, int[] B) {
        Arrays.sort(B);

        int answer = 0;
        visited = new boolean[B.length];
        for (int v : A) {
            int idx = binarySearch(B, v);
            int tmp = idx;
            if (visited[tmp]) {
                while (tmp < B.length) {
                    if (!visited[tmp]) {
                        idx = tmp;
                        break;
                    }
                    tmp++;
                }
            }
            if (!visited[idx] && B[idx] > v) {
                visited[idx] = true;
                answer++;
            }
        }
        return answer;
    }

    private static int binarySearch(int[] B, int v) {
        int sIndex = 0;
        int eIndex = B.length - 1;
        while (sIndex < eIndex) {
            int mid = (sIndex + eIndex) / 2;
            if (B[mid] > v) {
                eIndex = mid;
            } else {
                sIndex = mid + 1;
            }
        }
        return sIndex;
    }
}