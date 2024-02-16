/**
 * [Baekjoon] 1946. 신입사원
 * https://www.acmicpc.net/problem/1946
 *
 * 접근 방식
 * 1) arr 배열에 서류 순위를 인덱스로 하고 인터뷰 순위를 저장한다.
 * 2) arr를 순차적으로 탐색하며, 가장 높은 인터뷰 순위를 minRank 변수에 갱신해준다.
 *    이때, arr의 특정 인덱스(서류 순위) 값이 minRank보다 작다면 해당 사원은 뽑힐 수 있다는 것이므로 카운트해준다.
 * 3) 총 카운트 수를 출력한다.
 */

import java.util.*;
import java.io.*;

class Main {

    static int N;
    static int[] arr;

    private static void input(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int documentScore = Integer.parseInt(st.nextToken());
            int interviewScore = Integer.parseInt(st.nextToken());
            arr[documentScore] = interviewScore;
        }
    }

    private static int getCount() {
        int count = 1;
        int minRank = arr[1];
        for (int i=2; i<=N; i++) {
            if (minRank > arr[i]) {
                minRank = arr[i];
                count++;
            }
        }
        return count;
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            input(br);
            sb.append(getCount()).append("\n");
        }
        System.out.println(sb);
    }
}
