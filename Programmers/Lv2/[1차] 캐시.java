/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : [1차] 캐시 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17680
 */


import java.util.*;

class Solution {

    static Queue<String> cache = new LinkedList<>();

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return 5 * cities.length;
        }

        int time = 0;
        for (String city : cities) {
            city = city.toLowerCase();
            if (cache.remove(city)) {
                time += 1;
                cache.add(city);
            } else {
                time += 5;
                if (cache.size() >= cacheSize) {
                    cache.remove();
                }
                cache.add(city);
            }
        }

        return time;
    }
}
