package week5.assignments;

//문제 A: 최댓값과 최솟값을 동시에
//시간제한 : 0.500 sec 메모리제한 : 128 MB
//
//문제 설명
//주어진 N개의 정수에서 가장 큰 수와 가장 작은 수를 찾아주세요.
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=100)가 주어집니다. 
//각 테스트케이스마다 첫 줄에는 나열되는 정수의 개수 N(1<=N<=10,000)이 주어집니다. 그다음 줄에는 N개의 32비트 정수가 주어집니다. 
//출력 설명
//각 테스트케이스에 나열된 N개 정수 중 가장 큰 수와 가장 작은 수를 출력하세요. 가장 큰 수와 가장 작은 수 사이에는 하나의 공백만 있어야 합니다.
//입력 예시 Copy
//1
//5
//1 -3 2 10 5 
// 2147483648 1010010 22222 333333 43
//출력 예시 Copy
//10 -3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProblemA {
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		for (int T = Integer.parseInt(br.readLine()), t=0; t< T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			int N = Integer.parseInt(st.nextToken());
			int[] s = new int[N];
			
			st = new StringTokenizer(br.readLine()); 
			for(int i=0; i<N;i++) {
				s[i] = Integer.parseInt(st.nextToken());
			}
			
			int min, max;
			min = max = s[0];
			
			if(N > 1) {
				if (s[0] < s[1]) {
					max = s[1];
					min = s[0];
				} else {
					max = s[0];
					min = s[1];
				}
				for (int i=2; i <s.length-1; i+=2) {
					if (s[i] < s[i+1]) {
						if (s[i] < min) min = s[i];
						if (s[i+1] > max) max = s[i+1];
					} else {
						if (s[i+1] < min) min = s[i+1];
						if (s[i] > max) max = s[i];
					}
				}
				
				if(s.length % 2 != 0) {
					int i = s.length-2;
					if (s[i] < s[i+1]) {
						if (s[i] < min) min = s[i];
						if (s[i+1] > max) max = s[i+1];
					} else {
						if (s[i+1] < min) min = s[i+1];
						if (s[i] > max) max = s[i];
					}
				}
			}
			
			System.out.println(max + " " + min);
			
		}
		
		br.close();
	}
}