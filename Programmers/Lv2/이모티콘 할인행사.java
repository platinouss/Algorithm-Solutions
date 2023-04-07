/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 이모티콘 할인행사 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/150368
 */

class Solution {

    static int maxCount;
    static int maxTotal;
    static int[] percents;
    static int[] arr = {10, 20, 30, 40};

    public int[] solution(int[][] users, int[] emoticons) {
        percents = new int[emoticons.length];
        combination(0, emoticons, users);
        return new int[] {maxCount, maxTotal};
    }

    private static void combination(int depth, int[] emoticons, int[][] users) {
        if (depth == emoticons.length) {
            getResult(emoticons, users);
            return;
        }
        for (int k=0; k<4; k++) {
            percents[depth] = arr[k];
            combination(depth + 1, emoticons, users);
        }
    }

    private static void getResult(int[] emoticons, int[][] users) {
        int count = 0;
        int total = 0;
        int[] prices = new int[emoticons.length];
        for (int i=0; i<emoticons.length; i++) {
            prices[i] = (emoticons[i] * (100 - percents[i])) / 100;
        }
        for (int i=0; i<users.length; i++) {
            int sum = 0;
            for (int j=0; j<emoticons.length; j++) {
                if (percents[j] >= users[i][0]) {
                    sum += prices[j];
                }
            }
            if (users[i][1] <= sum) { count++; }
            else { total += sum; }
        }
        if (count >= maxCount) {
            if (count == maxCount) {
                maxTotal = Math.max(maxTotal, total);
            } else {
                maxCount = count;
                maxTotal = total;
            }
        }
    }
}