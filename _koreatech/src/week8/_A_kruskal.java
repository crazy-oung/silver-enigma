package week8;



//2021년도 1학기 9장 탐욕적 알고리즘 MST 문제
//문제 A는 prim 알고리즘과 kruskal 알고리즘을 이용하여 모두 통과해야 합니다. 이때 prim 알고리즘은 heap을 이용하여 구현해야 하며, 
//kruskal은 union-find을 이용하여 구현해야 합니다. 또 prim은 인접 행렬로 그래프를 처리해야 효과적으로 구현할 수 있습니다.

//문제 A: 가중치 무방향 그래프에서 최소신장트리 구하기
//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명
//주어진 가중치 무방향 그래프에서 최소신장트리를 구하여 주세요. 
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=1,000)가 주어집니다. 각 테스트케이스마다 첫 줄에는 그래프를 구성하는 노드의 수 N(1<=N<=100), 
//그래프를 구성하는 간선의 수 E(0<=E<=N(N-1)/2)가 주어집니다. 
//그다음 줄에는 E개의 간선 정보가 주어집니다. 
//각 간선마다 3개의 정수 a, b, c가 주어집니다. 
//a(0<=a<=N-1)는 간선의 시작 노드이고,  b(0<=b<=N-1)는 간선의 끝 노드이며, c(1<=c<=50)은 간선의 가중치 값입니다. 
//각 테스트케이스에 주어지는 그래프는 연결 그래프입니다.
//출력 설명
//각 테스트케이스마다 주어진 가중치 무방향 그래프의 최소신장트리를 구하고, 그 트리의 모든 간선의 합을 출력하여 주세요.
//입력 예시 Copy
//1
//5 7
//0 1 4 0 2 2 1 2 3 1 3 5 1 4 1 2 3 6 3 4 7
//출력 예시 Copy
//11

import java.util.*;

class Edge implements Comparable<Edge> {
	int from;
	int to;
	int distance;

	public Edge(int from, int to, int distance) {
		this.distance = distance;
		this.from = from;
		this.to = to;
	}

	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.distance, o.distance);
	}
} 

public class _A_kruskal {
	
	public static void main(String[] args) { 
		
		Scanner sc = new Scanner(System.in);
				
		for (int t = 0, T=sc.nextInt(); t < T; t++) {
			
	        int N = sc.nextInt();
	        int E = sc.nextInt();
	        
	        PriorityQueue<Edge> pq = new PriorityQueue<>(); 
			int[] p = new int[N]; 
			
			for (int i = 0; i < N; i++) { 
				p[i] = i; 
			} 
			
			for (int i = 0; i < E; i++) { 
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				pq.add(new Edge(a,b,c)); 
			}
			
			System.out.println(kruskalMST(pq, p, E)); 
			
		}
		
		
	}
	

	static void union(int[] p, int x, int y) {
		if (x < y) {
			p[find(p, y)] = find(p, x); 
		} else {
			p[find(p, x)] = find(p, y); 
		}
	} 

	static int find(int[] p, int x) {
		return p[x] == x? x: (p[x] = find(p, p[x]));
	} 
	
	static int kruskalMST(PriorityQueue<Edge> pq, int[] p, int E) {
		
		int T=0, cnt=0;
		
		while(!pq.isEmpty()) { 
			Edge edge = pq.poll(); 

			if (find(p, edge.from) != find(p, edge.to)) { 
				T += edge.distance; 
				if (++cnt == E) {
					break; 
				}
				
				union(p, edge.from, edge.to); 
			} 
		} 
		return T;
	}
	

}
