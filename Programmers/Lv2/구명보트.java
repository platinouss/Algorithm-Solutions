/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 구명보트 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42885
 */

import java.util.*;

class Solution {

    static int[] peoples;
    static boolean[] visited;

    public int solution(int[] people, int limit) {
        int totalCount = people.length;
        peoples = people;
        Arrays.sort(peoples);

        int count = 0;
        visited = new boolean[totalCount];
        for (int i=0; i<totalCount; i++) {
            if (visited[i]) {
                continue;
            }
            count++;
            visited[i] = true;
            int another = binarySearch(i+1, limit - peoples[i]);
            if (another > i && another < totalCount) {
                if (peoples[another] + peoples[i] <= limit) {
                    visited[another] = true;
                }
            }
        }
        return count;
    }

    private int binarySearch(int idx, int v) {
        int sIndex = idx;
        int eIndex = peoples.length - 1;
        int mid = (sIndex + eIndex) / 2;
        while (sIndex < eIndex) {
            mid = (sIndex + eIndex + 1) / 2;
            if (peoples[mid] <= v) {
                sIndex = mid;
            } else {
                eIndex = mid - 1;
            }
        }

        for (int i=sIndex; i>=idx; i--) {
            if (i < visited.length && !visited[i]) {
                return i;
            }
        }

        return idx;
    }
}