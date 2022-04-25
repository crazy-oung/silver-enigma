package week9;




//문제 E: 0-1 배낭 채우기
//시간제한 : 1.000 sec  메모리제한 : 256 MB
//
//문제 설명
//가방 하나와 N개의 물건이 주어집니다. 각 물건은 음의 아닌 이득 v와 음의 아닌 크기 w를 가지고, 가방은 용량 W를 가집니다. 
//N개의 물건 중 어떤 물건으로 가방을 채워야 가장 이득이 클까요? 물건은 포함하고나 포함하지 않을 수 있습니다. 물건의 일부만 포함할 수 없습니다.
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=1,000)가 주어집니다. 
//각 테스트케이스마다 첫 줄에는 가방의 용량 W(1<=W<=100)와 물건의 개수 N(1<=N<=500)이 주어집니다. 
//그다음 줄에는 N개의 물건에 대해 이득 v(1<=v<=50)와 무게 w(1<=w<=100)가 주어집니다. 첫 물건부터 차례로 0부터 번호를 할당한다.
//출력 설명
//각 테스트케이스마다 주어진 물건으로 가방을 채웠을 때 얻을 수 있는 가장 큰 이득을 출력해 주세요.
//입력 예시 Copy
//2
//6 4
//3 4 2 3 4 2 4 3
//30 3
//4 10 4 10 10 25
//출력 예시 Copy
//8
//10

import java.util.Scanner;

public class _E {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 0, T=sc.nextInt(); t < T; t++) {
			
	        int W = sc.nextInt();
	        int N = sc.nextInt();
	        
	        int[] v = new int[N];
	        int[] w = new int[N];
	        
	        int[][] dp = new int[N+1][W+1];
	        int max =0;
	        
	        for (int i=0; i<N; i++) {
	        	v[i] = sc.nextInt();
	        	w[i] = sc.nextInt();
	        } 
	        
	      
			System.out.println(knapsack(N, W, v, w));
	        
		}
		
	}
	
	static int knapsack(int N, int W, int[] v, int[] w) {
		int[][] dp = new int[N+1][W+1];
		int max =0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= W; j++) {
				if(w[i-1] <= j)
					dp[i][j] = Math.max(v[i-1] + dp[i-1][j - w[i-1]], dp[i-1][j]);
				else
					dp[i][j] = dp[i-1][j];
				max = Math.max(dp[i][j], max);
			}
		}
		
		return max;
	}
	
}
