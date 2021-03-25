package week2.assignment;


//문제 A: 소풍
//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명

//
//
//https://www.algospot.com/judge/problem/read/PICNIC
//입력 설명
//첫 줄에는 테스트케이스의 수 T(1<=T<=50)이 주어집니다. 
//각 테스트케이스의 첫 줄에는 학생의 수 N(2<=N<=10)과 친구 정보의 수 M(0<=M<=N*(N-1)/2)이 주어집니다. 
//여기서 N은 짝수입니다. 각 테스트케이스의 두 번째 줄에는 M개의 정수 쌍이 주어집니다. 
//이 정수 쌍의 각 정수값은 학생 번호에 해당하며, 학생 번호는 0부터 N-1 사이의 정수입니다. 
//같은 정보가 입력에 두 번 주어지지 않습니다.
//출력 설명
//각 테스트케이스마다 모든 학생을 친구끼리만 짝지어줄 수 있는 방법의 수를 출력합니다.
//입력 예시 Copy
//3
//2 1
//0 1
//4 6
//0 1 1 2 2 3 3 0 0 2 1 3
//6 10
//0 1 0 2 1 2 1 3 1 4 2 3 2 4 3 4 3 5 4 5
//출력 예시 Copy
//1
//3
//4

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problemA
{	

	public static void main(String[] args) throws IOException  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    	
		for (int T = Integer.parseInt(br.readLine()), i=0; i< T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			
			int M = Integer.parseInt(st.nextToken());
			boolean[][] bfArr = new boolean[M][M];
			boolean[]	picked = new boolean[M];
			int N = Integer.parseInt(st.nextToken());
					
			st = new StringTokenizer(br.readLine()); 
			for (int j=0; j < N; j++) {
				int fir = Integer.parseInt(st.nextToken());
				int sec = Integer.parseInt(st.nextToken());
				
				bfArr[fir][sec] = bfArr[sec][fir] = true;
			}
			
			System.out.println( pickBF(bfArr,picked) );
		}
		
		br.close();
    }
    
	
	public static int pickBF(boolean[][] bfArr, boolean[] picked) {
		
		
		int start = -1;
		for (int i = 0; i < picked.length; i++) {
            if(!picked[i]) {
            	start = i;
            	break;
            }
        }
		
		if (start < 0) return 1;
		
		int count = 0;
	
	    for (int i = start+1; i < picked.length; i++) {
	    	if (!picked[i] && bfArr[start][i]) {
	    		picked[start] = picked[i] = true;
				count += pickBF(bfArr, picked);
				picked[start] = picked[i] = false;
			}
	    }
	      
    	return count;
    }
	
}