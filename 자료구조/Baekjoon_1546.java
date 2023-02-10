package com.company.자료구조;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        
        long sum = 0;

        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            sum += A[i]; 
        }

        long max = 0;
        max = Arrays.stream(A).max().getAsInt();
        
        // 변환 점수의 평균을 구하는 식 (점수가 A, B, C인 경우)
        // (A / M * 100 + B / M * 100 + C / M * 100) / 3 = (A + B + C) * 100 / M / 3 
        System.out.println(sum * 100.0 / max / N);
    }
}