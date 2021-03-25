package week2.assignment;



//문제 D: HowSum: small
//시간제한 : 1.000 sec  메모리제한 : 128 MB  Special Judge
//LeetCode 39
//문제 설명
//목표 정수 M(>=0)과 N개의 서로 다른 양의 정수가 주어집니다. 이들 정수를 원하는 만큼 합하여 목표 정수를 만들 수 있는 방법을 알고 싶습니다. 
//예를 들어 목표 정수가 7이고, [5, 3, 4, 7]이 주어지면 3+4, 4+3, 7은 모두 7이므로 목표 정수를 만들 수 있습니다.    
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=10)가 주어집니다. 각 테스트케이스마다 첫 줄에는 목표 정수 M(0<=M<=19)과 N(2<=N<=5)이 주어집니다. 그다음 줄에는 N개의 서로 다른 양의 정수 X(2<=X<=19)가 주어집니다.
//출력 설명
//N개의 정수를 원하는 만큼 합하여 목표 정수를 만들 수 있으면 그것의 조합을 구성하는 수의 개수와 조합을 출력하고, 
//만들 수 없으면 -1를 출력합니다. 
//예를 들어 목표값이 8이고, [3, 2]가 주어지면 4 2 2 2 2 또는 3 3 3 2 등 답은 여러 가지가 존재할 수 있습니다.
//여러 답이 있을 때 그 중 하나만 출력하면 됩니다.


import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problemD
{	
	static List list = new ArrayList();
	
	public static void main(String[] args) throws IOException  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		for (int T = Integer.parseInt(br.readLine()), i=0; i< T; i++) {
			list = new ArrayList();
			
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			int[] X = new int[N];
			
			st = new StringTokenizer(br.readLine()); 
			for (int j = 0; j < N; j ++) {
				X[j] = Integer.parseInt(st.nextToken());
			}
			
			howSum(M, X);
			printArr();
		}
		
		br.close();
    }
    
	public static boolean howSum(int M, int[] X) {
    	if (M<0) return false;
    	if (M==0) return true;
    	
    	for (int i=0; i<X.length; i++) {
    		if (howSum(M-X[i], X)) {
    			list.add(X[i]);
    			return true;
    		}
    	}
    	return false;
    }
	
	
	
	public static void printArr() {
		if (list == null || list.size() == 0) {
			System.out.println("-1");
		} else {
			System.out.print(list.size()+" ");
			for (int i =0; i<list.size(); i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}
	}
}
