/**
 * [Baekjoon] 11000. 강의실 배정
 * https://www.acmicpc.net/problem/11000
 *
 * 접근 방식
 * 1) 모든 수업이 가능해야 하므로, 강의 시작 시간을 기준으로 오름차순 정렬되는 우선순위 큐에 강의 정보를 추가한다.
 * 2) 우선순위 큐에서 강의를 하나씩 뽑으면서, 강의실 종료 시간을 추가한다.
 *    이때, 이전 강의 종료 시간이 해당 강의 시작 시간보다 작거나 같다면 새로운 강의실을 추가하지 않고 종료 시간만 갱신한다.
 * 3) 강의실 개수를 반환한다.
 */

import java.util.*;
import java.io.*;

class Main {

    static class Lecture {
        int start, end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static int N;
    static PriorityQueue<Integer> rooms;
    static PriorityQueue<Lecture> lectures;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rooms = new PriorityQueue<>();
        lectures = new PriorityQueue<>((o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(start, end));
        }
    }

    public static void main (String[] args) throws IOException {
        input();
        while (!lectures.isEmpty()) {
            Lecture lecture = lectures.remove();
            if (!rooms.isEmpty() && rooms.peek() <= lecture.start) {
                rooms.remove();
            }
            rooms.add(lecture.end);
        }
        System.out.println(rooms.size());
    }
}
