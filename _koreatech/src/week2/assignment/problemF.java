package week2.assignment;

//문제 F: BestSum: small
//시간제한 : 1.000 sec  메모리제한 : 128 MB  Special Judge
//
//문제 설명
//목표 정수 M(>=0)과 N개의 서로 다른 양의 정수가 주어집니다. 이들 정수를 원하는 만큼 합하여 목표 정수를 만드는 경우의 수 중 가장 짧은 경우를 알고 싶습니다. 
//예를 들어 목표 정수가 7이고, [5, 3, 4, 7]이 주어지면 (3, 4), (4, 3), (7) 3개의 답 중에 가장 짭은 답은 (7) 입니다.    
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=10)가 주어집니다. 각 테스트케이스마다 첫 줄에는 목표 정수 M(0<=M<=19)과 N(2<=N<=5)이 주어집니다. 
//그다음 줄에는 N개의 서로 다른 양의 정수 X(2<=X<=19)가 주어집니다.
//출력 설명
//N개의 정수를 원하는 만큼 합하여 목표 정수를 만들 수 있으면 가장 짧은 길이와 답을 출력하고, 만들 수 없으면 -1를 출력합니다. 
//만약 가장 짧은 길이의 답이 여러 개 존재하면 그 중에 임의의 답을 출력하면 됩니다.
//도움
//입력:
//1
//7 4
//5 3 4 7
//출력:
//1 7



import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problemF
{
	
	public static void main(String[] args) throws IOException  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		for (int T = Integer.parseInt(br.readLine()), i=0; i< T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			int[] X = new int[N];
			
			st = new StringTokenizer(br.readLine()); 
			for (int j = 0; j < N; j ++) {
				X[j] = Integer.parseInt(st.nextToken());
			}
			
			List bestList = bestSum(M, X, new ArrayList());
			printArr(bestList);
		}
		
		br.close();
    }
    
	public static List bestSum(int M, int[] X, List list) {
    	if (M<0) return null;
    	if (M==0) return new ArrayList();
    	
    	List best = null;
    	for (int i=0; i < X.length; i++) {
    		list = bestSum(M-X[i], X, list);
    		if (list != null) {
    			if(best == null || best.size() > list.size()+1) {
    				list.add(X[i]);
    				best = list;
    			}
    		}
    	}
    	
    	return best;
    }
	
	
	
	public static void printArr(List bestList) {
		if (bestList == null || bestList.size() == 0) {
			System.out.println("-1");
		} else {
			System.out.print(bestList.size()+" ");
			for (int i =0; i<bestList.size(); i++) {
				System.out.print(bestList.get(i)+" ");
			}
			System.out.println();
		}
	}

}