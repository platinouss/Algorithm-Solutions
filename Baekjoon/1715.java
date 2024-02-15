/**
 * [Baekjoon] 1715. 카드 정렬하기
 * https://www.acmicpc.net/problem/1715
 *
 * 접근 방식
 * 1) 처음에 카드 개수를 모두 오름차순 정렬된 우선순위 큐에 추가한다음, 두 개의 카드 묶음을 뽑는다.
 * 2) 카드 두 묶음을 합친 후, 해당 묶음 수를 sum에 더하고 우선순위 큐에 추가한다.
 * 3) 2번은 N-1번 반복하고 최종 sum을 반환한다.
 */

import java.util.*;
import java.io.*;

class Main {

    static int N;
    static PriorityQueue<Integer> cards;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cards = new PriorityQueue<>();
        for (int i=0; i<N; i++) {
            cards.add(Integer.parseInt(br.readLine()));
        }
    }

    public static void main (String[] args) throws IOException {
        input();
        int sum = 0;
        for (int i=0; i<N-1; i++) {
            int first = cards.remove();
            int second = cards.remove();
            sum += first + second;
            cards.add(first + second);
        }
        System.out.println(sum);
    }
}
