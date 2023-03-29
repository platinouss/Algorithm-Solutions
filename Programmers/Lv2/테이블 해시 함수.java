/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 테이블 해시 함수 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/147354
 */

import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) {
                return o2[0] - o1[0];
            }
            return o1[col - 1] - o2[col - 1];
        });

        List<Integer> list = new ArrayList<>();
        for (int i = row_begin - 1; i < row_end; i++) {
            list.add(getS_i(i, data));
        }

        int answer = list.get(0);
        for (int i=1; i<list.size(); i++) {
            answer = answer ^ list.get(i);
        }

        return answer;
    }

    private static int getS_i(int index, int[][] data) {
        int result = 0;
        for (int value : data[index]) {
            result += (value % (index + 1));
        }
        return result;
    }
}