/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 카펫 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42842
 */

class Solution {
    public int[] solution(int brown, int yellow) {
        int width = 0;
        int height = 0;
        for (int i=1; i<=yellow; i++) {
            width = 0;
            height = i;
            if (yellow % i == 0) {
                width = yellow / i;
                if (isCorrect(width, height, brown)) {
                    break;
                }
            }
        }

        int[] answer = {width + 2, height + 2};
        return answer;
    }

    private static boolean isCorrect(int width, int height, int brown) {
        if (width < height) {
            return false;
        }
        if (brown == (width + 2) * 2 + (height * 2)) {
            return true;
        }
        return false;
    }
}