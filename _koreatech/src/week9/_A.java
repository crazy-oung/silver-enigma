package week9;


import java.util.Arrays;

//문제 A: CanSum: large
//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명
//목표 정수 M(>=0)과 N개의 서로 다른 양의 정수가 주어집니다.
//이들 정수를 원하는 만큼 합하여 목표 정수를 만들 수 있는지 알고 싶습니다.
//예를 들어 목표 정수가 7이고, [5, 3, 4, 7]이 주어지면 3+4는 7이므로 목표 정수를 만들 수 있습니다.   
//
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=1,000)가 주어집니다. 
//각 테스트케이스마다 첫 줄에는 목표 정수 M(0<=M<=1,000)과 N(2<=N<=100)이 주어집니다. 
//그다음 줄에는 N개의 서로 다른 양의 정수 X(1<=X<=200)가 주어집니다.
//출력 설명
//N개의 정수를 원하는 만큼 합하여 목표 정수를 만들 수 있으면 true를 출력하고, 만들 수 없으면 false를 출력합니다.
//
//입력 예시 Copy
//2
//7 4
//5 3 4 7
//7 2
//2 4
//
//출력 예시 Copy
//true
//false

import java.util.Scanner;

public class _A {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 0, T=sc.nextInt(); t < T; t++) {
			
	        int M = sc.nextInt();
	        int N = sc.nextInt();
	        
	        int[] X = new int[N];
	        
	        for (int i=0; i<N; i++) {
	        	X[i] = sc.nextInt();
	        } 
	        
	        System.out.println(canSum(M, X));
	        
		}
		
	}
	
	public static boolean canSum(int M, int[] X) {
		boolean[] table = new boolean[M+1];
		table[0] = true;

		for (int i=0; i<M; i++) {
			if (table[i]) {
				for (int x: X) {
					if(i+x <= M) table[i+x] = true;
				}
			}
		}
		
		return table[M];
	}
	
}
