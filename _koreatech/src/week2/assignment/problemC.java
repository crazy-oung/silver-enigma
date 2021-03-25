package week2.assignment;

//문제 C: CanSum: small
//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명
//목표 정수 M(>=0)과 N개의 서로 다른 양의 정수가 주어집니다. 이들 정수를 원하는 만큼 합하여 목표 정수를 만들 수 있는지 알고 싶습니다.
//예를 들어 목표 정수가 7이고, [5, 3, 4, 7]이 주어지면 3+4는 7이므로 목표 정수를 만들 수 있습니다.   
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=10)가 주어집니다. 각 테스트케이스마다 첫 줄에는 목표 정수 M(0<=M<=19)과 N(2<=N<=5)이 주어집니다. 
//그다음 줄에는 N개의 서로 다른 양의 정수 X(2<=X<=19)가 주어집니다.
//출력 설명
//N개의 정수를 원하는 만큼 합하여 목표 정수를 만들 수 있으면 true를 출력하고, 만들 수 없으면 false를 출력합니다.
//입력 예시 Copy
//2
//7 4
//5 3 4 7
//7 2
//2 4
//출력 예시 Copy
//true
//false


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problemC
{
    
    public static void main(String[] args) throws IOException  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		for (int T = Integer.parseInt(br.readLine()), i=0; i< T; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] X = new int[M];
			
			st = new StringTokenizer(br.readLine()); 
			for (int j = 0; j < M; j ++) {
				X[j] = Integer.parseInt(st.nextToken());
			}
			
	        System.out.println(canSum(N, X));
		}
		
		br.close();
    }
    
    public static boolean canSum(int N, int[] X) {
    	if (N<0) return false;
    	if (N==0) return true;
    	
    	for (int i=0; i<X.length; i++) {
    		if (canSum(N-X[i], X)) return true;
    	}
    	return false;
    }
   
    
}