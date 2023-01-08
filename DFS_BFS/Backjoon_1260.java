package com.company.DFS_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Backjoon_1260 {
    static int[][] map;
    static boolean[] visit;
    static int N;

    static int[] edge(int a,int b) {
        int[] re = {a,b};
        return re;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 정점의 개수
        int M = sc.nextInt(); // 간선의 개수
        int V = sc.nextInt(); // 탐색을 시작할 정점의 번호

        int[][] a = new int[M][2];

        for (int i = 0; i < M; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }

        // 입력되는 정점의 값은 1 이상의 정수이지만 배열의 index는 0 부터 시작이므로
        // ArrayIndexOutOfBoundsException 방지를 위해 인접 행렬의 행과 열 size는 1을 더하여 초기화
        map = new int[N+1][N+1];

        ArrayList<int[]> edgeList = new ArrayList<int[]>();

        for (int i = 0; i < M; i++) {
            edgeList.add(edge(a[i][0], a[i][1]));
        }

        for(int[] tmp : edgeList) {
            map[tmp[0]][tmp[1]] = 1;
            map[tmp[1]][tmp[0]] = 1;
        }

        // 입력되는 정점의 값은 1 이상의 정수이지만 배열의 index는 0부터 시작이므로 visit의 size는 1을 더하여 초기화
        visit = new boolean[N+1];
        dfs(V);

        System.out.println();

        // 입력되는 정점의 값은 1 이상의 정수이지만 배열의 index는 0부터 시작이므로 visit의 size는 1을 더하여 초기화
        visit = new boolean[N+1];
        bfs(V);
    }

    static void dfs(int i) { // 재귀 호출을 사용해 구현
        visit[i] = true; // 현재 node를 방문 처리
        System.out.print(i + " ");

        for (int j = 0; j < N+1; j++) {
            if (map[i][j] == 1 && visit[j] == false) {
                dfs(j);
            }
        }
    }

    static void bfs(int i) { // Queue를 사용해 구현
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visit[i] = true; // 현재 node를 방문 처리

        while (!q.isEmpty()) { // Queue가 비어있을 때까지 반복
            int temp = q.poll();
            System.out.print(temp + " "); // Queue에서 하나의 원소를 뽑아 출력

            for (int j = 0; j < N+1; j++) {
                if (map[temp][j] == 1 && visit[j] == false) { // 인접한 node들 중 아직 방문하지 않은 node들을 Queue에 삽입
                    q.offer(j);
                    visit[j] = true;
                }
            }
        }
    }
}
