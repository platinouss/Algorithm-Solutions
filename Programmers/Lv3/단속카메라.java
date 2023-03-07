/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 단속카메라 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42884
 */

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        int count = 1;
        int cameraPosition = routes[0][1];
        for (int i=1; i<routes.length; i++) {
            if (cameraPosition < routes[i][0]) {
                cameraPosition = routes[i][1];
                count++;
            }
        }

        return count;
    }
}