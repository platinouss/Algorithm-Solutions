/**
 * 백준 1208번 (골드 1)
 * 문제 이름 : 부분수열의 합 2
 * 알고리즘 분류 : 이분 탐색 or 투 포인터
 * 링크 : https://www.acmicpc.net/problem/1208
 */

import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static long result = 0;
    static List<Integer> leftSum = new ArrayList<>();
    static List<Integer> rightSum = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        calculateSum(0, N / 2, 0, leftSum);
        calculateSum(N / 2, N, 0, rightSum);

        Collections.sort(leftSum);
        Collections.sort(rightSum);

        getResult(value);

        if (value == 0) {
            result--;
        }
        System.out.println(result);
    }

    private static void getResult(int value) {
        int sIndex = 0;
        int eIndex = rightSum.size() - 1;

        while (sIndex < leftSum.size() && eIndex >= 0) {
            int v1 = leftSum.get(sIndex);
            int v2 = rightSum.get(eIndex);

            if (v1 + v2 == value) {
                long count1 = 0;
                long count2 = 0;
                while (sIndex < leftSum.size() && leftSum.get(sIndex) == v1 ) {
                    count1++;
                    sIndex++;
                }
                while (eIndex >= 0 && rightSum.get(eIndex) == v2) {
                    count2++;
                    eIndex--;
                }
                result += (count1 * count2);
            }

            if (v1 + v2 > value) {
                eIndex--;
            }
            if (v1 + v2 < value) {
                sIndex++;
            }
        }
    }

    private static void calculateSum(int sIndex, int eIndex, int sum, List<Integer> list) {
        if (sIndex == eIndex) {
            list.add(sum);
            return;
        }

        calculateSum(sIndex + 1, eIndex, sum, list);
        calculateSum(sIndex + 1, eIndex, sum + arr[sIndex], list);
    }
}