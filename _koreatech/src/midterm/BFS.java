package midterm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFS {
	
//	s = starting node
//			visited[s] = true
//			Q = empty queue of nodes Q.enqueue(s)
//			while Q is not empty do // O(n)
//			v = Q.dequeue()
//			for each edge (v, w) do // O(m)
//			if not visited[w] then visited[w] = true Q.enqueue(w)
	
//	s = starting node
//			visited[s] = true
//			distance[s] = 0 and distance[x] = ∞ for rest Q = queue of nodes with distances Q.enqueue(s)
//			while Q is not empty do
//			v = Q.dequeue()
//			for each edge (v, w) do
//			if not visited[w] then
//			visited[w] = true distance[w] = distance[v]+1 Q.enqueue(w)
	
//	components = []
//			set visited[] to all false for i = 1 to n do
//			if visited[i] then
			// i를 출발노드로 방문 가능한 모든 노드를
			// 리스트로 구축하여 반환하도록 BFS를 수정 components.add(BFS(G, i,));
	
	static ArrayList<ArrayList<Integer>>  graph = new ArrayList<ArrayList<Integer>>();
	static boolean[] visited = new  boolean[9];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t=0, T=Integer.parseInt(br.readLine()); t < T; t++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			int N = Integer.parseInt(st.nextToken());
//			visited = new boolean[N];
//			
//			st = new StringTokenizer(br.readLine());
//			for (int i=0; i< N; i++) {
//				
//			}
			
			// 그래프 초기화
	        for (int i = 0; i < 9; i++) {
	            graph.add(new ArrayList<Integer>());
	        }

	        // 노드 1에 연결된 노드 정보 저장 
	        graph.get(1).add(2);
	        graph.get(1).add(3);
	        graph.get(1).add(8);
	        
	        // 노드 2에 연결된 노드 정보 저장 
	        graph.get(2).add(1);
	        graph.get(2).add(7);
	        
	        // 노드 3에 연결된 노드 정보 저장 
	        graph.get(3).add(1);
	        graph.get(3).add(4);
	        graph.get(3).add(5);
	        
	        // 노드 4에 연결된 노드 정보 저장 
	        graph.get(4).add(3);
	        graph.get(4).add(5);
	        
	        // 노드 5에 연결된 노드 정보 저장 
	        graph.get(5).add(3);
	        graph.get(5).add(4);
	        
	        // 노드 6에 연결된 노드 정보 저장 
	        graph.get(6).add(7);
	        
	        // 노드 7에 연결된 노드 정보 저장 
	        graph.get(7).add(2);
	        graph.get(7).add(6);
	        graph.get(7).add(8);
	        
	        // 노드 8에 연결된 노드 정보 저장 
	        graph.get(8).add(1);
	        graph.get(8).add(7);

	        bfs(1);
	        
	        
	        Scanner sc = new Scanner(System.in);

	        // N, M을 공백을 기준으로 구분하여 입력 받기
	        n = sc.nextInt();
	        m = sc.nextInt();
	        sc.nextLine(); // 버퍼 지우기

	        // 2차원 리스트의 맵 정보 입력 받기
	        for (int i = 0; i < n; i++) {
	            String str = sc.nextLine();
	            for (int j = 0; j < m; j++) {
	                graph[i][j] = str.charAt(j) - '0';
	            }
	        }

	        // BFS를 수행한 결과 출력
	        System.out.println(bfs(0, 0));
			
		}
		
	}
	
	public static void bfs(int start){
	 Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        visited[start] = true;

        while(!q.isEmpty()) {

            int x = q.poll();
            System.out.print(x + " ");

            for(int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if(!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }
	}
	
	 public static int bfs(int x, int y) {
        // 큐(Queue) 구현을 위해 queue 라이브러리 사용 
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        // 큐가 빌 때까지 반복하기 
        while(!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            // 현재 위치에서 4가지 방향으로의 위치 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 미로 찾기 공간을 벗어난 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 벽인 경우 무시
                if (graph[nx][ny] == 0) continue;
                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Node(nx, ny));
                } 
            } 
        }
        // 가장 오른쪽 아래까지의 최단 거리 반환
        return graph[n - 1][m - 1];
    }

}


class Node {

    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
}

public class Main {

    public static int n, m;
    public static int[][] graph = new int[201][201];

    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우) 
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    public static int bfs(int x, int y) {
        // 큐(Queue) 구현을 위해 queue 라이브러리 사용 
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        // 큐가 빌 때까지 반복하기 
        while(!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            // 현재 위치에서 4가지 방향으로의 위치 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 미로 찾기 공간을 벗어난 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 벽인 경우 무시
                if (graph[nx][ny] == 0) continue;
                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Node(nx, ny));
                } 
            } 
        }
        // 가장 오른쪽 아래까지의 최단 거리 반환
        return graph[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력 받기
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 버퍼 지우기

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // BFS를 수행한 결과 출력
        System.out.println(bfs(0, 0));
    }

}
