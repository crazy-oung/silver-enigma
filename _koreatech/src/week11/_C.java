package week11;

//문제 C: CountSum 변형 - small - 되추적
//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명
//목표 정수 M(>=0)과 N개의 양의 정수가 주어집니다. 
// 이들 정수를 최대 한 번만 사용하여 그것의 합이 목표 정수를 만들 수 있는 조합의 수를 알고 싶습니다. 
//예를 들어 목표 정수가 7이고, [5, 3, 4, 7]이 주어지면 (3, 4), (7) 총 2가지 경우가 있습니다. 
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=100)가 주어집니다. 
//각 테스트케이스마다 첫 줄에는 목표 정수 M(0<=M<=200)과 N(2<=N<=25)이 주어집니다. 
//그다음 줄에는 N개의 양의 정수 X(1<=X<=50)가 주어집니다.
//출력 설명
//N개의 정수를 최대 한 번만 사용하여 그들의 합이 목표 정수가 되는 조합의 수를 출력해야 합니다.
//입력 예시 Copy
//2
//7 4
//5 3 4 7
//5 5
//2 5 2 1 2
//출력 예시 Copy
//2
//4

import java.util.Scanner;

public class _C {

	static boolean[] visited;
	static int cnt = 0, rs;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 0, T = sc.nextInt(); t < T; t++) {

			int M = sc.nextInt();
			int N = sc.nextInt();

			int[] X = new int[N];
			visited = new boolean[N];
			for (int i = 0; i < N; i++) {
				X[i] =  sc.nextInt();
			}
			countSum(X, 0, N, M);
			System.out.println(cnt);
		}

	}

	public static void countSum(int[] X, int start, int N, int r) {
		if (r == 0) {
			cnt ++;
			return;
		}
		if(r < 0) return;
		
		for (int i = start; i < N; i++) {
			visited[i] = true;
			countSum(X, i + 1, N, r - X[i]);
			visited[i] = false;
		}

	}

}
