package week6.assignments;


//문제 B: 방향 그래프에서 주기 찾기
//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명
//주어진 방향 그래프에 주기(cycle)가 있는지 찾아주세요. 
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=1,000)가 주어집니다. 
//각 테스트케이스마다 첫 줄에는 그래프를 구성하는 노드의 수 N(1<=N<=100)과 그래프를 구성하는 간선의 수 E(0<=E<=N(N-1))가 주어집니다. 
//그다음 줄에는 E개의 간선을 나타내는 정수 쌍이 주어집니다. 간선을 나타내는 정수 쌍 a와 b는 0부터 N-1까지의 수입니다. 
//출력 설명
//각 테스트케이스마다 주어진 그래프에 주기가 있으면 true를 출력하고 없으면 false를 출력하여 주세요.
//입력 예시 Copy
//3
//6 8
//0 3 3 2 1 2 1 4 4 2 4 5 5 1 0 1
//4 4
//0 1 1 2 0 3 3 2
//4 4
//0 1 1 2 2 3 3 0
//출력 예시 Copy
//true
//false
//true

import java.util.ArrayList;
import java.util.Scanner;


public class _B {
	
	static ArrayList<ArrayList<Integer>>  graph;
	static boolean[] visited, visiting;
	static boolean hasCycle;
	
	public static void dfs(int start){
       visited[start] = true;
       visiting[start] = true;

       for (int i = 0; i < graph.get(start).size(); i++) {
           int y = graph.get(start).get(i);
           if (!visited[y]) {
        	   dfs(y);
           }
           else if(!visiting[y]) {
        	   hasCycle = true;
        	   return;
           }
       }
       
       visiting[start] = false;
	}
	
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 0, T=sc.nextInt(); t < T; t++) {
			graph =  new ArrayList<ArrayList<Integer>>();
	        int N = sc.nextInt();
	        int E = sc.nextInt();
	        for (int i = 0; i < N; i++) {
	            graph.add(new ArrayList<Integer>());
	        }
	        
	        visited = new boolean[N];
	        visiting = new boolean[N];
	        
	        hasCycle = false;
	        for (int i = 0; i < E; i++) {
	            graph.get(sc.nextInt()).add(sc.nextInt());
	        }
	        dfs(0);
	        System.out.println(hasCycle);
		}
		
	}
	
}
//0 3 3 2 1 2 1 4 4 2 4 5 5 1 0 1
