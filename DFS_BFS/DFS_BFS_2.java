package com.company.DFS_BFS;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DFS_BFS_2 {
    static int[][] map;
    static boolean[] visit;
    static int N = 9;

    static int[] edge(int a,int b) {
        int[] re = {a,b};
        return re;
    }

    public static void main(String[] args) {

        map = new int[9][9];

        ArrayList<int[]> edgeList = new ArrayList<int[]>();
        edgeList.add(edge(0,1));
        edgeList.add(edge(1,2));
        edgeList.add(edge(1,3));
        edgeList.add(edge(2,4));
        edgeList.add(edge(2,3));
        edgeList.add(edge(3,4));
        edgeList.add(edge(3,5));
        edgeList.add(edge(5,6));
        edgeList.add(edge(5,7));
        edgeList.add(edge(6,8));

        for(int[] tmp : edgeList) {
            map[tmp[0]][tmp[1]] = 1;
            map[tmp[1]][tmp[0]] = 1;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        visit = new boolean[N];
        System.out.print("dfs: ");
        dfs(0);
        //dfs(3);

        System.out.println();

        visit = new boolean[N];
        System.out.print("bfs: ");
        bfs(0);
        //bfs(3);
    }

    static void dfs(int i) { // 재귀 호출을 사용해 구현
        visit[i] = true; // 현재 node를 방문 처리
        System.out.print(i + " ");

        for (int j = 0; j < N; j++) {
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

            for (int j = 0; j < N; j++) {
                if (map[temp][j] == 1 && visit[j] == false) { // 인접한 node들 중 아직 방문하지 않은 node들을 Queue에 삽입
                    q.offer(j);
                    visit[j] = true;
                }
            }
        }
    }
}
