package com.company.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_1238 {
    static class Node implements Comparable<Baekjoon_1238.Node>{
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
        public int compareTo(Baekjoon_1238.Node o) { // 가중치 비교
            return Integer.compare(this.cost, o.cost);
        }
    }

    //노드의 크기, 출발지
    public static int[] dijkstra(int n, int start, ArrayList<Baekjoon_1238.Node>[] graph) {
        boolean[] check = new boolean[n + 1]; // 정점을 방문하였는지 판단
        int[] dist = new int[n + 1]; // 출발지로부터의 거리
        int INF = Integer.MAX_VALUE; // 무한대 가정

        Arrays.fill(dist, INF);
        dist[start] = 0; // 출발지

        PriorityQueue<Baekjoon_1238.Node> pq = new PriorityQueue<>();
        pq.offer(new Baekjoon_1238.Node(start, 0)); // 출발지 정점과 가중치를 우선순위 큐에 삽입

        while(!pq.isEmpty()) { // 우선순위 큐가 빌 때까지 반복
            int nowVertex = pq.poll().index; // 우선순위 큐의 가장 앞에 저장된 값을 가져와 현재 정점으로 설정 후 삭제한다.

            if(check[nowVertex]) continue; // 방문했다면 다음 과정으로
            check[nowVertex] = true; // 방문하지 않았으므로 해당 정점 방문 처리

            //현재 정점과 연결된 정점의 가중치 비교
            for(Baekjoon_1238.Node next : graph[nowVertex]) {
                if(dist[next.index] > dist[nowVertex]+ next.cost) { // 현재까지 출발지에서 next로 갈 때 가장 빠른 거리 > 출발지에서 nowVertex 방문 후 next로 가는 거리
                    dist[next.index] = dist[nowVertex] + next.cost; // 최소 거리 갱신

                    pq.offer(new Baekjoon_1238.Node(next.index, dist[next.index])); // 갱신한 정점을 우산순위 큐에 삽입
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {

        //그래프 입력 받기
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //정점의 개수, 간선의 개수, 출발 정점 번호
        st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Baekjoon_1238.Node>[] graph, reverse_graph;

        graph = new ArrayList[N+1];
        reverse_graph = new ArrayList[N+1];

        for (int i = 0; i <= N; i++)  {
            graph[i] = new ArrayList<>();
            reverse_graph[i] = new ArrayList<>();
        }

        StringTokenizer st2;
        for(int i = 0 ; i < M; i++) {
            st2 = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(st2.nextToken()); // source 정점
            int w = Integer.parseInt(st2.nextToken()); // destination 정점
            int cost = Integer.parseInt(st2.nextToken()); // 가중치

            graph[v].add(new Baekjoon_1238.Node(w, cost)); // 그래프 생성
            reverse_graph[w].add(new Baekjoon_1238.Node(v, cost)); // 입력을 반대로 받는 그래프 생성
        }

        int[] graph_dist = new int[N + 1];
        int[] reverse_graph_dist = new int[N + 1];
        int[] shortest_dist = new int[N + 1];
        //다익스트라 알고리즘 수행
        graph_dist = dijkstra(N, X, graph);
        reverse_graph_dist = dijkstra(N, X, reverse_graph);

        for (int i = 1; i < N + 1; i++) {
            shortest_dist[i] = graph_dist[i] + reverse_graph_dist[i];
        }

        System.out.print(Arrays.stream(shortest_dist).max().getAsInt());
    }
}
