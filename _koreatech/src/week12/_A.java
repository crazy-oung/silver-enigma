package week12;
//문제 A: 외판원 문제

//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명
//주어진 가중치 방향 그래프에서 최적 일주여행경로를 찾아 주세요. 이 그래프에서 가중치는 음이 아닌 정수입니다. 
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=100)가 주어집니다. 각 테스트케이스마다 첫 줄에는 그래프의 노드 수 N(3<=N<=20)가 주어지고, 
//그 다음 N개 줄에 0번째 노드부터 다른 노드까지 간선의 가중치 W(0<=W<=100)가 주어집니다. 만약 노드 v에서 노드 w가 없으면 가중치로 -1이 주어집니다.  
//노드 v에서 노드 v로의 간선은 존재하지 않지만 가중치를 0으로 주어집니다.
//출력 설명
//각 테스트케이스마다 최적 일주여행경로의 길이를 출력하여 주세요.
//입력 예시 Copy
//2
//5
//0 14 4 10 20
//14 0 7 8 7
//4 5 0 7 16
//11 7 9 0 2
//18 7 17 4 0
//4
//0 2 9 -1
//1 0 6 4
//-1 7 0 8
//6 3 -1 0
//출력 예시 Copy
//30
//21

import java.util.Scanner;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node {
	int level; // 트리 레벨
	int bound; // 가능한 최솟값
	int tour[]; // 일주여행경로
}

public class _A {

	private static int INF = 99, N;
	static int arr[][];
	static int dp[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 0, T = sc.nextInt(); t < T; t++) {

			N = sc.nextInt();

			arr = new int[N][N];
			dp = new int[N][(1 << N) - 1];

			for (int i = 0; i < N; i++)
				Arrays.fill(dp[i], INF);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			System.out.println(tsp(0, 1));
		}
	}

	static int final_path[] = new int[N + 1];
	static boolean visited[] = new boolean[N];
	static int final_res = Integer.MAX_VALUE;

	static void copyToFinal(int curr_path[]) {

	}

	// Function to find the minimum edge cost
	// having an end at the vertex i
	static int firstMin(int adj[][], int i) {
		int min = Integer.MAX_VALUE;
		for (int k = 0; k < N; k++)
			if (adj[i][k] < min && i != k)
				min = adj[i][k];
		return min;
	}

	// function to find the second minimum edge cost
	// having an end at the vertex i
	static int secondMin(int adj[][], int i) {
		int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
		for (int j = 0; j < N; j++) {
			if (i == j)
				continue;

			if (adj[i][j] <= first) {
				second = first;
				first = adj[i][j];
			} else if (adj[i][j] <= second && adj[i][j] != first)
				second = adj[i][j];
		}
		return second;
	}

	static void TSPRec(int adj[][], int curr_bound, int curr_weight, int level, int curr_path[]) {
		if (level == N) {
			if (adj[curr_path[level - 1]][curr_path[0]] != 0) {
				int curr_res = curr_weight + adj[curr_path[level - 1]][curr_path[0]];

				if (curr_res < final_res) {
					for (int i = 0; i < N; i++)
						final_path[i] = curr_path[i];
					final_path[N] = curr_path[0];

					final_res = curr_res;
				}
			}
			return;
		}

		for (int i = 0; i < N; i++) {

			if (adj[curr_path[level - 1]][i] != 0 && visited[i] == false) {
				int temp = curr_bound;
				curr_weight += adj[curr_path[level - 1]][i];

				if (level == 1)
					curr_bound -= ((firstMin(adj, curr_path[level - 1]) + firstMin(adj, i)) / 2);
				else
					curr_bound -= ((secondMin(adj, curr_path[level - 1]) + firstMin(adj, i)) / 2);

				if (curr_bound + curr_weight < final_res) {
					curr_path[level] = i;
					visited[i] = true;

					TSPRec(adj, curr_bound, curr_weight, level + 1, curr_path);
				}

				curr_weight -= adj[curr_path[level - 1]][i];
				curr_bound = temp;

				Arrays.fill(visited, false);
				for (int j = 0; j <= level - 1; j++)
					visited[curr_path[j]] = true;
			}
		}
	}

	static void tsp(int adj[][]) {
//		int curr_path[] = new int[N + 1];
//		int curr_bound = 0;
//
//		Arrays.fill(curr_path, -1);
//		Arrays.fill(visited, false);
//
//		for (int i = 0; i < N; i++)
//			curr_bound += (firstMin(adj, i) + secondMin(adj, i));
//
//		curr_bound = (curr_bound == 1) ? curr_bound / 2 + 1 : curr_bound / 2;
//
//		visited[0] = true;
//		curr_path[0] = 0;
//
//		TSPRec(adj, curr_bound, 0, 1, curr_path);
		
		PriorityQueue<Node> Q = new PriorityQueue<Node>();

		Node u = new Node(), v = new Node();

		v.level = 0;
		v.profit = 0;
		v.weight = 0;
		v.bound = bound(Weight, n, v, items);

		maxProfit = 0;
		Q.add(v);

		while (!Q.isEmpty()) {

			v = Q.poll();

			Q.remove();

			if (v.bound > maxProfit) {

				u.level = v.level + 1;
				u.weight = v.weight + items[u.level - 1].weight;
				u.profit = v.profit + items[u.level - 1].profit;

				if (u.weight <= Weight && u.profit > maxProfit) {
					maxProfit = u.profit;
				}
				u.bound = bound(Weight, n, u, items);
				if (u.bound > maxProfit) Q.add(u);

				u.weight = v.weight;
				u.profit = v.profit;

				u.bound = bound(Weight, n, u, items);
				if (u.bound > maxProfit) Q.add(u);

			}

		}
	}

//    
//    private static int tsp(int node, int visit){
//        if(visit == (1 << N) - 1){
//            if(arr[node][0] == 0) return INF;
//            return arr[node][0];
//        }
//
//        if(dp[node][visit] != INF)
//            return dp[node][visit];
//
//        for(int i = 0 ; i < N; i++){
//            int next = visit | (1 << i);
//            if(arr[node][i] == 0 || (visit & (1 << i)) != 0) continue;
//
//            dp[node][visit] = Math.min(dp[node][visit], tsp(i, next) + arr[node][i]);
//        }
//
//        return dp[node][visit];
//    }
}
