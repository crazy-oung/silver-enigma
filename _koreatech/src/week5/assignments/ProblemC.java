package week5.assignments;

//문제 C: k번째 요소 찾기
//시간제한 : 0.500 sec  메모리제한 : 128 MB
//
//문제 설명
//주어진 N개의 정수에서 k번째로 큰 수를 찾아주세요.
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=100)가 주어집니다. 각 테스트케이스마다 첫 줄에는 나열되는 정수의 개수 N(1<=N<=10,000)과 찾고자 하는 위치 k(1<=k<=N)이 주어집니다. 그다음 줄에는 N개의 32비트 정수가 주어집니다. 
//출력 설명
//각 테스트케이스에 나열된 N개 정수 중 k번째 요소를 출력하세요. 
//입력 예시 Copy
//1
//5 2
//8 5 4 3 7
//출력 예시 Copy
//4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProblemC {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		for (int T = Integer.parseInt(br.readLine()), t=0; t< T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			
			int N = Integer.parseInt(st.nextToken()), idx = Integer.parseInt(st.nextToken());
			
			int[] s = new int[N];
			
			st = new StringTokenizer(br.readLine()); 
			for(int i=0; i<N;i++) {
				s[i] = Integer.parseInt(st.nextToken());
			}
			
			System.out.println(RSelect(s, 0, N-1, idx-1) );
		}
		
		br.close();

	}
	
	
	static int RSelect(int[] A, int l, int r, int i) {
		if (l == r) return A[l];
		choosePivot(A, l, r);
		
        int pLoc = partition(A, l, r);
        
        if (pLoc == i) return A[pLoc];
        if (pLoc < i) return RSelect(A, pLoc + 1, r, i);
        return RSelect(A, l, pLoc - 1, i);
	}

	static int partition(int[] A, int l, int r) {
        int p = A[l];
		int i = l+1;
		
		for(int j=l+1; j<=r; j++) {
			if (A[j] < p) {
				swap(A, i, j);
				++i;
			}
		}
		swap(A, l, i-1);
		return i-1;
	}
	
	private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
        
    }
	
	private static void choosePivot(int[] A, int l, int r) {
		int randnum = (int) ((Math.random() * (r - l)) + l); // l~r
		swap(A, randnum, l);
	}
 

    
}

