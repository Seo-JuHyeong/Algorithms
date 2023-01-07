package com.company.순열_조합;

import java.util.Scanner;

public class Baekjoon_10973 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
        if (nextPerm(a)) {
            for (int i = 0; i < N; i++) {
                System.out.print(a[i] + " ");
            }
        } else {
            System.out.println("-1");
        }
    }

    public static void swap(int[] a, int j, int k) {
        int temp = a[j];
        a[j] = a[k];
        a[k] = temp;
    }

    public static boolean nextPerm(int[] a) {
        int l = a.length - 1;
        int j = 0;
        int k = l;

        // a[j] < a[j-1]를 만족하는 가장 큰 j 찾기
        for (int i = 1; i <= l; i++) {
            if (a[i-1] >= a[i]) {
                j = i;
            }
        }

        // 처음에 오는 순열인 경우
        if (j == 0) {
            return false;
        }

        // k >= j 이면서 a[j-1] > a[k]를 만족하는 가장 큰 k 찾기
        for (int i = j; i <= l; i++){
            if (a[i] < a[j-1]) {
                k = i;
            }
        }

        // a[j-1]과 a[k]를 swap
        swap(a,j-1, k);

        // a[j]부터 순열을 뒤집기 (오름차순 -> 내림차순)
        for (int i = j; i < l; i++, l--) {
            swap(a, i, l);
        }

        return true;
    }
}
