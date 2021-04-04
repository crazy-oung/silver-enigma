package week3;



//문제 A: 역쌍 구하기
//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명
//주어진 N개 정수에서 역쌍의 개수를 구하여 주세요. 역쌍(inversion)이란 i<j에 대해 A[i]>A[j]이면 역쌍입니다. 
//예를 들어 [1, 3, 5, 2, 4, 6]에서 (3, 2), (5, 2), (5, 4)는 역쌍입니다.
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=100)가 주어집니다. 
//각 테스트케이스마다 첫 줄에는 나열되는 정수의 개수 N(1<=N<=10,000)이 주어집니다. 그다음 줄에는 정수 K(32비트 정수)가 주어집니다. 
//출력 설명
//각 테스트케이스마다 역쌍의 개수를 출력하여 주세요.
//입력 예시 Copy
//1
//6
//1 3 5 2 4 6
//출력 예시 Copy
//3


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
			
			int N = Integer.parseInt(st.nextToken());

			int[] K = new int[N];
			
			st = new StringTokenizer(br.readLine()); 
			for (int j = 0; j < N; j ++) {
				K[j] = Integer.parseInt(st.nextToken());
			}
			
			System.out.println(countInversions(K, 0,K.length - 1));

		}
		
		br.close();
    }
    
    
 
    public static int countInversions(int[] K, int l, int r) {
        int count = 0;
 
        if (l < r) {
            int m = (l + r) / 2;
            count += countInversions(K, l, m);
            count += countInversions(K, m + 1, r);
            count += countSplitInversion(K, l, m, r);
        }
 
        return count;
    }
    
    public static int countSplitInversion(int[] K, int l,  int m, int r) {
    	 
        int[] left = Arrays.copyOfRange(K, l, m + 1);
        int[] right = Arrays.copyOfRange(K, m + 1, r + 1);
 
        int i = 0, j = 0, k = l, swaps = 0;
 
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                K[k++] = left[i++];
            else {
                K[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }
        while (i < left.length)  K[k++] = left[i++];
        while (j < right.length) K[k++] = right[j++];
        return swaps;
    }
 
  

}
