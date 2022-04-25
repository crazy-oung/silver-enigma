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
//첫 줄에는 테스트케이스 T(1<=T<=1,000)가 주어집니다. 각 테스트케이스마다 
//첫 줄에는 그래프를 구성하는 노드의 수 N(1<=N<=100), 
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

class Vertex implements Comparable<Vertex> {
	int from, distance;

	public Vertex(int from, int distance) {
		this.distance = distance;
		this.from = from;
	}

	@Override
	public int compareTo(Vertex v) {
		return Integer.compare(this.distance, v.distance);
	}
}

public class _A_prim {

	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 0, T = sc.nextInt(); t < T; t++) {

			int N = sc.nextInt();
			int E = sc.nextInt();

			ArrayList<ArrayList<Vertex>> graph = new ArrayList<ArrayList<Vertex>>();
			visited = new boolean[N];

			for (int i = 0; i < N; i++) {
				graph.add(new ArrayList<Vertex>());
			}

			for (int i = 0; i < E; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();

				graph.get(a).add(new Vertex(b, c));
				graph.get(b).add(new Vertex(a, c));
			}
			
			
			
			System.out.println(primMST(graph, N));
		}

	}
	
	
	static int primMST(ArrayList<ArrayList<Vertex>> graph, int N) {
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		pq.add(new Vertex(0, 0));
		int rs = 0, cnt=0;
		
		while (!pq.isEmpty()) {
			Vertex vertex = pq.poll(); 
			
			if (visited[vertex.from]) continue;
			
			visited[vertex.from] = true; 
			rs += vertex.distance; 
			
			for (Vertex next : graph.get(vertex.from)) {
				if (!visited[next.from]) {
					pq.add(next);
				}
			} 
			
			if (++cnt == N) break;
		}
		
		
		return rs;
	}

	

}
