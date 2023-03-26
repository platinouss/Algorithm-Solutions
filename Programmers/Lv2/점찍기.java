/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 점찍기 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/140107
 */

import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long count = 0;
        for (int i=0; i<=d; i+=k) {
            long len = (long) Math.sqrt(Math.pow(d, 2) - Math.pow(i, 2));
            count += Math.floor(len / k) + 1;
        }
        return count;
    }
}