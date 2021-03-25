package week1.assignment;

//문제 B: 가장 많이 등장한 수 찾기
//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명
//주어진 N개의 정수에서 가장 많이 등장하는 수를 찾아주세요.
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=100)가 주어집니다. 각 테스트케이스마다 한 줄에 나열되는 정수의 개수 N(1<=N<=10,000)와 N개의 양의 정수 K(0<=K<=49)가 주어집니다. 
//출력 설명
//각 테스트케이스에 나열된 N개 정수 중 가장 많이 등장하는 수를 출력합니다. 가장 많이 등장하는 수는 항상 유일합니다. 

//입력 예시 
//1
//10 5 2 2 2 2 2 2 3 1 4

//출력 예시 
//2

//B 문제는 강의노트에 제시된 2가지 방법 대신에 다른 방법을 사용하여 해결해야 합니다.

import java.util.*;
import java.io.*;

public class problemB
{
     public static void main(String[] args) throws IOException {
          
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        int T = Integer.parseInt(br.readLine()); 
        
        for (int testCase = 0; testCase < T ; testCase++) {
        	StringTokenizer st = new StringTokenizer(br.readLine()); 
	        int N = Integer.parseInt(st.nextToken()); 
	        int[] K = new int[N];
	        
	        int max = 0;
	        
	        for (int i = 0; i < N; i++) {
	        	int a = Integer.parseInt(st.nextToken()); //첫번째 호출
		        K[i] = a;
		        max = (max < a)? a : max;
	        }
	        
	        
	        int t = max + 1;
	        int[] count = new int[t];
	        for (int i = 0; i < t; i++) {
	            count[i]= 0;
	        }
	        
	        for (int i = 0; i < N; i++) {
	            count[K[i]]++;
	        }

	        int result = 0;
	        int Ktot = count[0];
	        for (int i = 1; i < t; i++) {
	            if (count[i] > Ktot) {
	            	Ktot = count[i];
            		result = i;
	            }
	        }
	        System.out.println(result);
	        
          }
        br.close();
     }
}