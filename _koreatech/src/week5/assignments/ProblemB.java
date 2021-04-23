package week5.assignments;

//문제 B: 두 번째로 큰 값
//시간제한 : 0.500 sec  메모리제한 : 128 MB
//
//문제 설명
//주어진 N개의 정수에서 두 번째로 큰 수를 찾아주세요.
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=100)가 주어집니다. 각 테스트케이스마다 첫 줄에는 나열되는 정수의 개수 N(2<=N<=10,000)이 주어집니다. 그다음 줄에는 N개의 32비트 정수가 주어집니다. 
//출력 설명
//각 테스트케이스에 나열된 N개 정수 중 두 번째로 큰 수를 출력하세요.
//입력 예시 Copy
//3
//6
//1 -3 10 2 5 9
//2
//7 10
//2
//10 10
//출력 예시 Copy
//5
//7
//10


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProblemB {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		for (int T = Integer.parseInt(br.readLine()), t=0; t< T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			int N = Integer.parseInt(st.nextToken());
			int[] s = new int[N*2-1];
			
			st = new StringTokenizer(br.readLine());
			
			int sN = N-1;
			for(int i=0; i<N;i++) {
				s[sN+i] = Integer.parseInt(st.nextToken());
			}
			
			
			sN = s.length-1;
			if (s[sN] < s[sN-1]) {
				s[0] = s[sN-1];
				s[1] = s[sN];
			} else {
				s[0] = s[sN];
				s[1] = s[sN-1];
			}
			
			if(N > 2) {
				N--;
				for (int i=2; i <=N; i+=2) {
					if (s[sN-i] < s[sN-(i-1)]) {
						if (s[sN-(i-1)] > s[0]) {
							swap(s, 0, i); 
							s[0] = s[sN-(i-1)];
						} else {
							s[i] = s[sN-(i-1)];
						}
					} else {
						if (s[sN-i] > s[0]) {
							swap(s, 0, i); 
							s[0] = s[sN-(i-1)];
						} else {
							s[i] = s[sN-(i-1)];
						}
					}
					
				}
				
				if(s.length % 2 != 0) {
					int i = s.length-2;
					if (s[sN-i] < s[sN-(i-1)]) {
						if (s[sN-(i-1)] > s[0]) {
							swap(s, 0, i); 
							s[0] = s[sN-(i-1)];
						} else {
							s[i] = s[sN-(i-1)];
						}
					} else {
						if (s[sN-i] > s[0]) {
							swap(s, 0, i); 
							s[0] = s[sN-(i-1)];
						} else {
							s[i] = s[sN-(i-1)];
						}
					}
				}

			}
			
			System.out.println(Arrays.toString(s));
			System.out.println(s[1]);
			
		}
		
		br.close();
	}
	
	private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp; 
    }
	
}

