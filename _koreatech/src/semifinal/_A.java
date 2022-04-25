package semifinal;

import java.util.Scanner;
import java.util.Arrays;

//문제 A: 가장 긴 공통 부분문자열
//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명
//두 개의 문자열이 주어집니다. 두 문자열에서 공통된 부분 문자열의 길이를 출력하여 주세요. 
//공통된 문자열이 없으면 0을 출력하여 주세요. 여기서 부분문자열이란 기존 문자열에서 일부 문자를 제거한 문자열을 말하여, 원래 문자의 순서는 유지되는 문자열을 말합니다. 예를 들어 "ace"는 "abcde"의 부분문자열입니다.
//
//
//알고리즘 2021년 기말문제. 동적 프로그래밍(메모이제이션 또는 테뷸레이션)으로 해결해야 합니다.
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=100)이 주어집니다. 각 테스트케이스는 두 줄로 주어지며, 각 줄에 문자열 S(1<=len(S)<=400)가 주어집니다. 
//출력 설명
//각 테스트케이스마다 가장 긴 공통 부분문자열을 찾아 그것의 길이를 출력하여 주세요. 공통 부분문자열이 없으면 0을 출력하여 주세요.
//입력 예시 Copy
//3
//abcde
//ace
//abc
//abc
//abc
//def
//출력 예시 Copy
//3
//3
//0
public class _A {
	static String[] S;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 0, T = sc.nextInt(); t < T; t++) {
			S = new String[2];
			String X = sc.next();
			String Y = sc.next();
			
			
			System.out.println(solution(X, Y) );
		}

	}

	public static int solution(String X, String Y) {
		
		int[][] table = new int[X.length()+1][Y.length()+1];

		int max =0;
		for (int i = 0; i < X.length(); i++) {
			
			for (int j = 0; j < Y.length(); j++) {
				
				if (X.charAt(i) == Y.charAt(j)) {
					table[i+1][j+1] = table[i][j]+1;
					
					max = Math.max(max, table[i+1][j+1]);
				} 
			}
		}
	   
		return max;
//		
//		int[][] dp = new int[S[0].length()][S[1].length()];
//		int c = 0;
//		String rslt = "";
//
//		for (int i = 0; i < S[0].length(); i++) {
//			for (int j = 0; j < S[1].length(); j++) {
//
//				if (S[0].charAt(i) == S[1].charAt(j)) {
//					if (i == 0 || j == 0) {
//						dp[i][j] = 1;
//					} else {
//						dp[i][j] = dp[i - 1][j - 1] + 1;
//					}
//
//					if (dp[i][j] > c) {
//						c = dp[i][j];
//						
//						rslt = "";
//						for (int k = 0; k < c; k++) {
//							rslt += S[0].charAt(i - c + 1 + k);
//						}
//					} else if (dp[i][j] == c) {
//						
//						rslt = "";
//						for (int k = 0; k < c; k++) {
//							rslt += S[0].charAt(i - c + 1 + k);
//						}
//					}
//				} else {
//					dp[i][j] = 0;
//				}
//
//			}
//		}
//
//		System.out.println(rslt);
//
//		return rslt.length();
	}
}
