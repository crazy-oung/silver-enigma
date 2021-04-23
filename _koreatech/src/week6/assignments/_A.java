package week6.assignments;


//문제 A: 무방향 그래프의 연결 여부
//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명
//주어진 무방향 그래프에서 고립된 연결 부분 그래프(connected component)의 수가 몇 개인지 찾아주세요. 
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=1,000)가 주어집니다. 
//각 테스트케이스마다 첫 줄에는 그래프를 구성하는 노드의 수 N(1<=N<=100)과 그래프를 구성하는 간선의 수 E(0<=E<=N(N-1)/2)가 주어집니다. 
//그다음 줄에는 E개의 간선을 나타내는 정수 쌍이 주어집니다.
//간선을 나타내는 정수 쌍 a와 b는 0부터 N-1까지의 수입니다. 
//출력 설명
//각 테스트케이스마다 주어진 그래프가 고립된 연결 부분 그래프의 수와 이와 같은 부분 그래프 중 가장 큰 부분 그래프의 노드 수를 출력하여 주세요.
//입력 예시 Copy
//2
//10 8
//0 2 0 4 2 4 4 6 4 8 1 3 5 7 5 9
//12 10
//10 10 0 2 0 4 2 4 4 6 4 8 1 3 5 7 5 9 10 11
//13 11
//0 2 0 4 2 4 4 6 4 8 1 3 5 7 5 9 10 10 10 11 12 12
//출력 예시 Copy
//3 5
//4 5

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _A {
	
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	public static int bfs(int start){
		
		Queue<Integer> q = new LinkedList<>();
		int cnt = 1;
	    q.offer(start);
	    visited[start] = true;
	    
	    while(!q.isEmpty()) {
	        int x = q.poll();
	        for(int i = 0; i < graph.get(x).size(); i++) {
	            int y = graph.get(x).get(i);
	            if(!visited[y]) {
	                q.offer(y);
	                visited[y] = true;
	                cnt++;
	            }
	        }
	    }
	        
   
        return cnt;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 0, T=sc.nextInt(); t < T; t++) {
			graph =  new ArrayList<ArrayList<Integer>>();
	        int N = sc.nextInt();
	        int E = sc.nextInt();
	        
	        visited = new boolean[N];
	        for (int i = 0; i < N; i++) {
	            graph.add(new ArrayList<Integer>());
	        }
	        for (int i = 0; i < E; i++) {
	            graph.get(sc.nextInt()).add(sc.nextInt());
	        }

	        int count = 0;
	        int maxComponent = 0;
	        for (int i=0; i<N; i++) {
		        if(!visited[i]){
		        	 maxComponent = Math.max(maxComponent, bfs(i));
		        	 ++count;
		        }
	        }
	        
	        System.out.println(count + " " + maxComponent);
	        
		}
		
		
	}
	
	
}
