package semifinal;



//문제 B: 최적의 작업 할당
//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명
//N개의 작업이 있고, 그 작업을 수행할 수 있는 N명이 있습니다. 각 사람은 각 작업을 완료하는데 소요되는 시간이 다릅니다. 전체 작업 완료 시간을 최소화하도록 각 사람에게 작업을 할당하여 주세요. 각 사람에게 하나의 작업을 할당해야 합니다.
//
//
//알고리즘 2021년 기말문제. 분기한정법으로 해결해야 합니다.
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=10)가 주어집니다. 각 테스트케이스마다 첫 줄에는 작업의 수 N(3<=N<=5)이 주어집니다. 그다음 N개의 줄에 걸쳐 각 사람이 각 작업을 하는데 소요되는 시간 S(1<=S<=20)가 주어집니다. 
//출력 설명
//각 테스트케이스마다 전체 작업 완료 시간을 최소화하도록 작업을 할당하였을 때 완료하는 시간을 출력하여 주세요.
//입력 예시 Copy
//1
//4
//9 2 7 8
//6 4 3 7
//5 8 1 8
//7 6 9 4
//출력 예시 Copy
//13
import java.util.Scanner;
public class _B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 0, T = sc.nextInt(); t < T; t++) {
			int N = sc.nextInt();
			int[][] S = new int[N][N];
			p = new int [N][N];
			s = new int [N][N];
			for (int i=0; i < N; i++) {
				for (int j=0; j < N; i++) {
					S[i][j] = sc.nextInt();
				}
			}

		}
		
		System.out.println();
	}
	
	public static int solution(int N, int[][] S) {
		int max =0,sum=0;
		int[] bound = new int[N];
		int[] chk = new int[N];
		
		for(int i=N-1;i<=0; i--) {
			max =0;
			for(int j=0;j<N; j++) {
				if(max < S[i][j]) max = S[i][j];
			}
			sum += max;
			bound[i] = sum;
		}
		
		sum =0;
		for(int i=0;i<N;i++) {
			chk[i] =0;
		}
		
		
		sol(1,0, N,bound, 0);

		return 0;
	}
	static int[][] p,s;
	
	public static void sol(int n, int m,int N, int[] bound, int ans) {
		if((m+bound[n]) <= ans) return;
		
		if (n == N+1) {
			if(ans < m) {
				ans = m;
				for(int i=0;i<n; i++) {
					p[i] = s[i];
				}
			}
			return;
		}
		int j=0;
		for (int i=0; i<N;i ++) {
			
		}
		
	}
}
