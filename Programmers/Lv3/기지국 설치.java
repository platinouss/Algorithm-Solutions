/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 기지국 설치 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12979
 */

import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int index = 1;
        int answer = 0;
        int maxLength = w*2 + 1;
        for (int station : stations) {
            int sIndex = station - w;
            int eIndex = station + w;
            if (index > sIndex) {
                index = eIndex + 1;
                continue;
            }
            if (sIndex < 1) {
                sIndex = 1;
            }
            answer += Math.ceil((double) (sIndex - index) / maxLength);
            index = eIndex + 1;
        }
        if (index < n+1) {
            answer += Math.ceil((double) (n+1 - index) / maxLength);
        }

        return answer;
    }
}