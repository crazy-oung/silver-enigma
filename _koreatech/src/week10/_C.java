package week10;

//문제 C: 방향 그래프에서 최단 경로 찾기

//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명
//방향 그래프가 주어졌을 때 모든 노드에서 다른 모든 노드로 가는 최단 경로를 찾아주세요. 
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=100)가 주어집니다. 
//각 테스트케이스마다 첫 줄에는 방향 그래프의 노드 수 N(1<=N<=100)와 간선 수 E(0<=E<=N(N-1))가 주어집니다. 
//그다음 줄에는 E개의 간선 정보가 주어집니다. 각 간선마다 시작노드 S(0<=S<=N-1), 끝노드 D(0<=D<=N-1), 가중치 W(-100<=W<=100) 3개 값이 주어집니다.
//출력 설명
//주어진 테스트케이스마다 방향 그래프의 음의 주기가 존재하면 -1을 출력하고, 
//음의 주기가 없을 경우 두 노드간 최단 경로가 가장 먼 경로의 정보를 출력하여 주세요. 
//경로의 정보는 시작노드, 끝노드, 경로 길이 3개 값을 출력해야 합니다. 
//두 노드간 최단 경로가 가장 먼 것이 여러 개 있으면 시작노드 값이 가장 작은 것을 출력하고, 시작노드가 동일한 것이 여러 개 있다면 그 중에 끝노드 값이 가장 작은 것을 출력하여 주세요. 
//예를 들어 주어진 그래프에서 두 노드간 최단 경로가 가장 먼 것의 길이가 10일 때, 노드 0에서 노드 2의 최단 경로가 10이고, 노드 1에서 노드 4의 최단 경로도 10이면 0 2 10을 출력하여 주세요. 
//또 주어진 그래프에서 두 노드간 최단 경로가 가장 먼 것의 길이가 7일 때, 노드 0에서 노드 2의 최단 경로가 7이고, 노드 0에서 노드 4의 최단 경로도 7이면 0 2 7를 출력하여 주세요.  
//입력 예시 Copy
//3
//5 7
//0 1 5 0 2 3 0 3 -2 1 3 -1 2 1 -2 3 4 3 4 2 -1
//5 10
//0 1 1 0 3 1 0 4 5 1 0 9 1 2 3 1 3 2 2 3 4 3 2 2 3 4 3 4 0 3
//5 7
//0 1 5 0 2 3 0 3 -2 1 3 -1 2 1 -2 2 4 -1 3 4 3
//출력 예시 Copy
//-1
//2 1 11
//0 2 3

import java.util.Scanner;
import java.util.Arrays;


public class _C {

	static final int MAX = 9999999;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 0, T = sc.nextInt(); t < T; t++) {

			int n = sc.nextInt();
	        int m = sc.nextInt();
	        int[][] graph = new int[m][m];
	        
	        for (int i = 0; i < m; i++) {
	            Arrays.fill(graph[i], MAX);
	        }

	        for (int a = 1; a <= n; a++) {
	            for (int b = 1; b <= n; b++) {
	                if (a == b) graph[a][b] = 0;
	            }
	        }

	        for (int i = 0; i < m; i++) {
	            int a = sc.nextInt();
	            int b = sc.nextInt();
	            int c = sc.nextInt();
	            graph[a][b] = c;
	        }

	        for (int k = 1; k <= n; k++) {
	            for (int a = 1; a <= n; a++) {
	                for (int b = 1; b <= n; b++) {
	                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
	                }
	            }
	        }

	       boolean flag = false;
	        for (int i =0;i<m; i++) {
	        	if(graph[i][i] < 0) {
	        		flag = true;
	        		break;
	        	}
	        }
	        
	        int[] d = new int[3];
	        int min =0;
	        if (flag) {
	        	System.out.println(-1);
	        } else {

	        }
			
		}

	}
	
	
}

