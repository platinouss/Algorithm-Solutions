/**
 * 백준 1644번 (골드 3)
 * 문제 이름 : 소수의 연속합
 * 알고리즘 분류 : 투 포인터, 에라토스테네스의 체
 * 링크 : https://www.acmicpc.net/problem/1644
 */

import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] isNotPrime = new boolean[N + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i=2; i*i<=N; i++) {
            if (!isNotPrime[i]) {
                for (int j=i*i; j<=N; j+=i) {
                    isNotPrime[j] = true;
                }
            }
        }
        for (int i=1; i<=N; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);
            }
        }
        int sum = 0;
        int sIndex = 0;
        int eIndex = 0;
        int count = 0;
        while (true) {
            if (sum >= N) {
                sum -= primes.get(sIndex);
                sIndex++;
            } else {
                if (eIndex >= primes.size()) {
                    break;
                }
                sum += primes.get(eIndex);
                eIndex++;
            }
            if (sum == N) {
                count++;
            }
        }
        System.out.println(count);
    }
}