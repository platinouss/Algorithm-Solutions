/**
 * 프로그래머스 Lv2
 * 문제 이름 : 최솟값 만들기
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12941
 */

import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        for (int i=0; i<A.length; i++) {
            answer += A[i] * B[B.length - 1 - i];
        }

        return answer;
    }
}