package week6.assignments;

//문제 C: 가중치 그래프에서 최단 경로 길이 구하기
//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명
//주어진 가중치 그래프에서 출발노드로부터 주어진 노드들까지의 최단 경로의 길이를 구하여 주세요.
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=1,000)가 주어집니다. 
//각 테스트케이스마다 첫 줄에는 그래프를 구성하는 노드의 수 N(1<=N<=100), 
//그래프를 구성하는 간선의 수 E(0<=E<=N(N-1)/2), 출발노드 S(0<=S<=N-1), 
//목적 노드의 수 K(1<=K<=N-1), K개 만큼의 목적 노드 d(0<=d<=N-1)가 주어집니다. 
//그다음 줄에는 E개의 간선 정보가 주어집니다. 각 간선마다 3개의 정수 a, b, c가 주어집니다. 
//a(0<=a<=N-1)는 간선의 시작 노드이고,  b(0<=b<=N-1)는 간선의 끝 노드이며, c(1<=c<=50)은 간선의 가중치 값입니다.
//출력 설명
//각 테스트케이스마다 출발 노드에서 주어진 목적 노드까지의 최단 경로의 길이를 출력합니다. 
//이때 목적 노드까지 경로가 존재하지 않으면 해당 경로의 길이 값으로 -1을 출력합니다.
//입력 예시 Copy
//2
//4 5 0 2 3 2
//0 1 1 0 2 4 1 2 2 1 3 6 2 3 3
//5 6 2 2 4 3
//0 1 1 1 2 3 2 0 1 0 4 2 2 4 4 3 4 1
//출력 예시 Copy
//6 3
//3 -1

import java.util.*;

class Node implements Comparable<Node>{

    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(Node o) {
        return distance - o.distance;
    }
}

public class _C {

    static int N, E, S, K;
    static ArrayList<ArrayList<Node>> graph;
    static int[] pd, d;
    static final int MAX = Integer.MAX_VALUE;

    public static void dijkstra(int start) {
    	 PriorityQueue<Node> pq = new PriorityQueue<>();
         pq.offer(new Node(start, 0));
         pd[start] = 0;
         while(!pq.isEmpty()) { 
             Node node = pq.poll();
             int dist = node.getDistance(); 
             int now = node.getIndex(); 
            
             if (pd[now] < dist) continue;
             
             for (int i = 0; i < graph.get(now).size(); i++) {
                 int cost = pd[now] + graph.get(now).get(i).getDistance();
                
                 if (cost < pd[graph.get(now).get(i).getIndex()]) {
                     pd[graph.get(now).get(i).getIndex()] = cost;
                     pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                 }
             }
         }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 0, T=sc.nextInt(); t < T; t++) {
			graph =  new ArrayList<ArrayList<Node>>();
			
	        N = sc.nextInt();
	        E = sc.nextInt();
	        S = sc.nextInt();
	        K = sc.nextInt();
	        pd = new int[N];
	        
	        d = new int[K];
	        for(int i=0; i < K; i++) {
	        	d[i] = sc.nextInt();
	        }
	        for (int i = 0; i < N; i++) {
	            graph.add(new ArrayList<Node>());
	        }

	        for (int i = 0; i < E; i++) {
	            int a = sc.nextInt();
	            int b = sc.nextInt();
	            int c = sc.nextInt();
	            graph.get(a).add(new Node(b, c));
	        }
	        
	        Arrays.fill(pd, MAX);
	        
        	dijkstra(S);
        	
    		for (int i=0;i<K;i++) {
    			print(d[i]);
    		}
        	
    		System.out.println();

		}
        
    }
    
    static void print(int i) {
    	if (pd[i] == MAX) {
            System.out.print(-1+ " ");
        }  else {
            System.out.print(pd[i] +" ");
        }
    }
}

