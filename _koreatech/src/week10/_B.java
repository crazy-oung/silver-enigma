package week10;

//문제 B: 최적의 이진 검색 트리
//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명
//키와 그 키를 검색하는 빈도가 주어졌을 때 최적의 이진 트리를 만들어 주세요. 
//필요한 것은 그와 같은 빈도를 검색할 때 필요한 총 비용입니다. 
//예를 들어 2개의 키가 있는데, 각 키의 검색 빈도가 34, 50이면 빈도가 높은 키를 루트로 이진 검색 트리를 만들면 되고, 
//그때 총 비용은 50x1 + 34x2 = 118입니다. 이처럼 총 비용을 계산할 때 키의 실제 값은 중요하지 않습니다.
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=10,000)가 주어집니다. 
//각 테스트케이스마다 첫 줄에는 키의 개수 N(1<=N<=100)이 주어지고, 그다음 줄에는 각 키에 대한 검색 빈도 F(1<=F<=50)가 주어집니다. 
//출력 설명
//각 테스트케이스마다 해당 키를 주어진 검색 빈도를 검색하였을 때 총 비용을 계산하여 출력하여 주세요.
//입력 예시 Copy
//2
//2
//34 50
//3
//34 8 50
//출력 예시 Copy
//118
//142

import java.util.Scanner;

public class _B {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 0, T=sc.nextInt(); t < T; t++) {
			
			int N = sc.nextInt();
			int[] F = new int[N];
			for (int i=0; i < N; i++) {
				F[i] = sc.nextInt();
			}

	        System.out.println(optimalBST(F, 0, N-1));
	        
		}
		
	}
	
	public static int optimalBST(int freq[], int i, int j) {

		if(j<i) {	
			return 0;
		}
		if(j==i) {	
			return freq[i];
		}
		
		int sum =0;
		
		for(int k=i; k<=j; k++) {
			sum += freq[k];
		}


		int min = Integer.MAX_VALUE;

		for(int r=i; r<=j; ++r) {
			
			int cost = optimalBST(freq, i, r-1) + optimalBST(freq, r+1, j);
			if(cost < min) {
				min = cost;
			}
		}

		return min+sum;
	
	}
	
	
	
}
