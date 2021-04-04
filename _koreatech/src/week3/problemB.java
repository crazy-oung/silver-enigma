package week3;



//문제 B: 합계가 가장 큰 구간 찾기
//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명
//N개의 정수가 주어집니다. 합계가 가장 큰 연속된 부분 구간을 찾아주세요. 이 구간의 크기는 최소 1이상이어야 합니다.
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=100)가 주어집니다. 
//각 테스트케이스마다 첫 줄에는 나열되는 정수의 개수 N(1<=N<=10,000)이 주어집니다. 
//그다음 줄에는 정수 K(-105<=K<=105)가 주어집니다. 
//출력 설명
//각 테스트케이스마다 합계가 가장 큰 연속된 부분 구간을 구하고, 그 합계를 출력하여 주세요.
//입력 예시
//2
//9
//-2 1 -3 4 -1 2 1 -5 4
//1
//-1000
//출력 예시 
//6
//-1000


import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problemB
{	

	public static void main(String[] args) throws IOException  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		for (int T = Integer.parseInt(br.readLine()), i=0; i< T; i++) {
			
			
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			
			int N = Integer.parseInt(st.nextToken());

			int[] K = new int[N];
			
			st = new StringTokenizer(br.readLine()); 
			for (int j = 0; j < N; j ++) {
				K[j] = Integer.parseInt(st.nextToken());
			}
			
			System.out.println(arrMaxSum(K, 0, K.length - 1));

		}
		
		br.close();
    }
 
	static int arrMaxSum(int K[], int l, int r) {
        if (l == r)  return K[l];
        int m = (l + r) / 2;
        
        return Math.max( Math.max (arrMaxSum(K, l, m), arrMaxSum(K, m + 1, r))
        				, arrSumMax(K, l, m, r));
    }
	static int arrSumMax(int K[], int l, int m, int r) {
    	
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            sum = sum + K[i];
            if (sum > left_sum) left_sum = sum;
        }
 
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = m + 1; i <= r; i++) {
            sum = sum + K[i];
            if (sum > right_sum) right_sum = sum;
        }
 
        return Math.max(left_sum + right_sum, Math.max(left_sum, right_sum));
    }

	
}
