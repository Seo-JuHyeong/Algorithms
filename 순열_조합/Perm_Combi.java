package com.company.순열_조합;
import java.util.Arrays;

public class Perm_Combi {

    static int N;
    static int R;
    static int[] input; //길이 N 뽑을 대상
    static int[] numbers;//길이 R 뽑힌 것
    static boolean[] isSelect; //선택된거 기억

    public static void main(String[] args) {
        N = 4;
        R = 4;

        input = new int[N];
        isSelect = new boolean[N];
        numbers = new int[R];

        for (int i = 1; i < N; i++) {
            input[i] = i;
        }

        perm(0);
        //repetitionPerm(0);
        //combi(0,0);
        //repetitionCombi(0,0);
        //subset(0);
    }

    public static void perm(int cnt) { // 순열 함수
        if (cnt == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSelect[i])
                continue;
            numbers[cnt] = input[i];
            isSelect[i] = true;
            perm(cnt + 1);
            isSelect[i] = false;
        }
    }

    public static void repetitionPerm(int cnt) { // 중복 순열 함수
        if (cnt == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = 0; i < N; i++) {
            numbers[cnt] = input[i];
            repetitionPerm(cnt + 1);
        }
    }

    public static void combi(int cnt, int start) { // 조합 함수
        if (cnt == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = start; i < N; i++) {
            numbers[cnt] = input[i];
            combi(cnt + 1, i + 1);
        }
    }

    public static void repetitionCombi(int cnt, int start) { // 중복 조합 함수
        if (cnt == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = start; i < N; i++) {
            numbers[cnt] = input[i];
            repetitionCombi(cnt + 1, i );
        }
    }

    public static void subset(int idx) { // 부분 집합 함수
        if(idx==N) {
            for(int i = 0 ; i < N ; i++) {
                System.out.print(isSelect[i]?input[i]+", ":"");
            }
            System.out.println();
            return;
        }
        isSelect[idx] = true;
        subset(idx+1);
        isSelect[idx] = false;
        subset(idx+1);
    }
}
