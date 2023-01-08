package com.company.DFS_BFS;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.Stack;
import java.util.NoSuchElementException;

public class DFS_BFS {
    static class Queue<T> { // 객체를 만들 때 data type을 명시하도록 구현

        class Node<T> { // 같은 type을 받는 Node 선언
            private T data; // data 선언
            private Node<T> next; // 다음 node 선언

            public Node(T data) { // 생성자
                this.data = data;
            }
        }

        // Queue는 앞, 뒤로 주소를 알고 있어야 함
        private Node<T> first;
        private Node<T> last;

        public void add (T item) { // 추가 함수
            Node<T> t = new Node<T>(item); // 해당 T type의 item으로 node 생성

            if (last != null) { // 마지막 node가 있다면
                last.next = t; // 그 뒤에 새로 생성한 node를 붙힘
            }
            last = t;

            if (first == null) { // data가 없다면
                first = last; // 같은 값을 할당
            }
        }

        public T remove() { // 삭제 함수
            if (first == null) { // Queue가 비어있다면 (null check)
                throw new NoSuchElementException();
            }

            T data = first.data; // data 백업
            first = first.next; // 다음 node를 first로

            if (first == null) { // data가 없다면
                last = null;
            }

            return data;
        }

        public T peek() { // first 값 반환 함수
            if (first == null) { // Queue가 비어있다면 (null check)
                throw new NoSuchElementException();
            }
            return first.data;
        }

        public boolean isEmpty() { // 비어있는지 확인하는 함수
            return first == null; // first가 null인지 확인
        }


    }

    static class Graph { // Graph class 선언
        static class Node { // Node class 선언
            int data;
            LinkedList<Node> adjacent; // 인접한 node들과의 관계 설정을 LinkedList로 표현
            boolean marked; // 방문 여부를 판단하는 flag

            Node (int data) { // Node 생성자
                this.data = data;
                this.marked = false;
                adjacent = new LinkedList<Node>(); // LinkedList를 준비
            }
        }

        Node[] nodes; // node들을 저장할 배열 생성
        Graph(int size) { // Graph 생성자 (Graph의 node 개수를 고정하여 구현)
            nodes = new Node[size]; // 고정된 node 개수만큼의 크기를 가진 배열 생성
            for (int i = 0; i < size; i++) { // data와 index가 같도록 구현
                nodes[i] = new Node(i); // 0 ~ 개수-1 까지의 node 생성 후 배열 방에 저장
            }
        }

        void addEdge (int i1, int i2) { // 두 node의 관계를 저장하는 함수
            Node n1 = nodes[i1];
            Node n2 = nodes[i2];

            // 2개의 node에 인접한 node를 저장하는 LinkedList에 상대방이 있는지 확인하고 없으면 서로 추가
            if (!n1.adjacent.contains(n2)) {
                n1.adjacent.add(n2);
            }
            if (!n2.adjacent.contains(n1)) {
                n2.adjacent.add(n1);
            }
        }

        void dfs() { // 아무것도 넘기지 않고 호출 시 0번 node부터 실행
            dfs(0);
        }
        void dfs (int index) { // 시작 index를 받아서 dfs 순회 결과를 출력하는 함수
            Node root = nodes[index]; // 해당 index로 node를 가져옴
            Stack<Node> stack = new Stack<Node>(); // Stack 생성
            stack.push(root); // 현재 node를 Stack에 추가
            root.marked = true; // Stack에 들어갔음을 표시

            while (!stack.isEmpty()) { // Stack에 data가 없을 때까지 반복
                Node r = stack.pop(); // Stack에서 data를 하나 가져옴

                for (Node n : r.adjacent) { // 가져온 node의 자식(이웃 node)들을 Stack에 추가
                    if (n.marked == false) { // Stack에 추가되지 않은 node들만 추가
                        n.marked = true;
                        stack.push(n);
                    }
                }
                visit(r); // 가져온 node 출력
            }
        }

        void dfsR(Node r) { // 재귀 호출을 사용하여 구현한 dfs 함수
            if (r == null) return; // 받은 node가 null인 경우 그냥 반환
            r.marked = true; // 호춯이 된 것을 node에 marking
            visit(r); // 자식들을 호출하기 전에 해당 node의 data를 먼저 출력

            for (Node n : r.adjacent) {
                if (n.marked == false) {
                    dfsR(n); // 호출이 되지 않은 자식들을 호출
                }
            }
        }
        void dfsR() { // 아무것도 넘기지 않고 호출 시 0번 node부터 실행
            dfsR(0);
        }
        void dfsR(int index) { // 배열의 index를 통해 접근 가능히도록
            Node r = nodes[index];
            dfsR(r); // 해당 node를 시작으로 재귀 호출 진행
        }

        void bfs() { // 아무것도 넘기지 않고 호출 시 0번 node부터 실행
            bfs(0);
        }
        void bfs(int index) { // 시작 index를 받아서 bfs 순회 결과를 출력하는 함수
            Node root = nodes[index]; // 해당 index로 node를 가져옴
            Queue<Node> queue = new Queue<Node>(); // Queue 생성
            queue.add(root); // Queue에 data 추가
            root.marked = true; // 추가하였다고 marking

            while (!queue.isEmpty()) { // Queue가 비어있을 때까지 반복
                Node r = queue.remove(); // Queue에서 data를 하나 가져옴
                for (Node n : r.adjacent) { // Queue에서 꺼낸 자식 (이웃 node)들을 Queue에 추가
                    if (n.marked == false) { // Queue에 추가되지 않은 node들만 추가
                        n.marked = true;
                        queue.add(n);
                    }
                }
                visit(r); // 가져온 node 출력
            }
        }

        void visit(Node n) { // 방문할 때 출력해주는 함수
            System.out.print(n.data + " ");
        }
    }

    public static void main (String[] args) {
        Graph g = new Graph(9); // 9개 node의 Graph 생성
        /*
        --------------------
            0
           /
         1 --- 3      7
         |   / | \  /
         | /   |  5
         2     4   \
                    6 -- 8
        --------------------  관계 명시
         */
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);

        /*
        결과
        --------------------
        DFS(0)
        0 1 3 5 7 6 8 4 2
        DFSR(0) - 재귀 호출
        0 1 2 4 3 5 6 8 7
        BFS(0)
        0 1 2 3 4 5 6 7 8
        --------------------
        DFS(3)
        3 5 7 6 8 4 2 1 0
        DFSR(3) - 재귀 호출
        3 1 0 2 4 5 6 8 7
        BFS(3)
        3 1 2 4 5 0 6 7 8
        --------------------
         */

        g.dfs();
        //g.dfsR();
        //g.bfs();
        //g.dfs(3);
        //g.dfsR(3);
        //g.bfs(3);
    }
}
