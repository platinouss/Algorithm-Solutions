/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 택배 배달과 수거하기 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/150369
 */

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int deliverCount = 0, pickupCount = 0;
        long answer = 0;
        for (int i=n-1; i>=0; i--) {
            int count = 0;
            while (deliverCount < deliveries[i] || pickupCount < pickups[i]) {
                count++;
                deliverCount += cap;
                pickupCount += cap;
            }
            deliverCount -= deliveries[i];
            pickupCount -= pickups[i];
            answer += (i + 1) * count * 2;
        }
        return answer;
    }
}