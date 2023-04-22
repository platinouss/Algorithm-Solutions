/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 당구 연습 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/169198
 */

import java.util.*;

class Solution {
    public static int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        Point start = new Point(startX, startY);
        for (int i=0; i<balls.length; i++) {
            int min = Integer.MAX_VALUE;
            List<Point> allBalls = move(m, n, start, new Point(balls[i][0], balls[i][1]));
            for (Point point : allBalls) {
                min = Math.min(min, getDistance(start, point));
            }
            answer[i] = min;
        }

        return answer;
    }

    private static List<Point> move(int m, int n, Point start, Point ball) {
        List<Point> list = new ArrayList<>();
        if(!(start.x == ball.x && start.y > ball.y)) {
            list.add(new Point(ball.x, ball.y * -1));
        }
        if(!(start.x == ball.x && start.y < ball.y)) {
            list.add(new Point(ball.x, n + (n-ball.y)));
        }
        if(!(start.y == ball.y && start.x < ball.x)) {
            list.add(new Point(m + (m-ball.x), ball.y));
        }
        if(!(start.y == ball.y && start.x > ball.x)) {
            list.add(new Point(ball.x * -1 , ball.y));
        }

        return list;
    }

    private static int getDistance(Point start, Point ball){
        int maxX = Math.max(start.x, ball.x);
        int maxY = Math.max(start.y, ball.y);
        int minX = Math.min(start.x, ball.x);
        int minY = Math.min(start.y, ball.y);

        return (int) Math.pow(maxX - minX, 2) + (int) Math.pow(maxY - minY, 2);
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}