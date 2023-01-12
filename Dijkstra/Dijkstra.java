package com.company.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra {
    static class Node implements Comparable<Node>{
        int index;
        int cost;

        // 정점 번호 및 가중치(cost) 저장
        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        /**PriorityQueue<Node> pq = new PriorityQueue<Node>
         ((o1, o2) -> Integer.compare(o1.cost, o2.cost));
         **/
        @Override
        public int compareTo(Node o) { // 가중치 비교
            return Integer.compare(this.cost, o.cost);
        }
    }

    static ArrayList<Node>[] graph;

    //노드의 크기, 출발지
    public static void dijkstra(int n, int start) {
        boolean[] check = new boolean[n + 1]; // 정점을 방문하였는지 판단
        int[] dist = new int[n + 1]; // 출발지로부터의 거리
        int INF = Integer.MAX_VALUE; // 무한대 가정

        Arrays.fill(dist, INF);
        dist[start] = 0; // 출발지

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0)); // 출발지 정점과 가중치를 우선순위 큐에 삽입

        while(!pq.isEmpty()) { // 우선순위 큐가 빌 때까지 반복
            int nowVertex = pq.poll().index; // 우선순위 큐의 가장 앞에 저장된 값을 가져와 현재 정점으로 설정 후 삭제한다.

            if(check[nowVertex]) continue; // 방문했다면 다음 과정으로
            check[nowVertex] = true; // 방문하지 않았으므로 해당 정점 방문 처리

            //현재 정점과 연결된 정점의 가중치 비교
            for(Node next : graph[nowVertex]) {
                if(dist[next.index] > dist[nowVertex]+ next.cost) { // 현재까지 출발지에서 next로 갈 때 가장 빠른 거리 > 출발지에서 nowVertex 방문 후 next로 가는 거리
                    dist[next.index] = dist[nowVertex] + next.cost; // 최소 거리 갱신

                    pq.offer(new Node(next.index, dist[next.index])); // 갱신한 정점을 우산순위 큐에 삽입
                }
            }
        }

        //최소거리 출력
        for(int i = 1; i < dist.length; i++) {
            if(dist[i] == INF) System.out.print("Infinity "); // 무한대인 경우
            else System.out.print(dist[i] + " ");
        }
    }

    public static void main(String[] args) throws IOException {

        //그래프 입력 받기
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //정점의 개수, 간선의 개수
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++)  graph[i] = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0 ; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(st.nextToken()); // source 정점
            int w = Integer.parseInt(st.nextToken()); // destination 정점
            int cost = Integer.parseInt(st.nextToken()); // 가중치

            graph[v].add(new Node(w, cost)); // 그래프 생성
        }

        int start = Integer.parseInt(bf.readLine()); // 출발 정점 생성

        //다익스트라 알고리즘 수행
        dijkstra(n, start);
    }
}
