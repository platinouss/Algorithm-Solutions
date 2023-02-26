/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 점프와 순간 이동 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12980
 */

import java.util.*;

public class Solution {
    public int solution(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 2 == 1) {
                n--;
                count++;
            }
            n = n >> 1;
        }

        return count;
    }
}