package week9;



//문제 D: BestSum: large
//시간제한 : 1.000 sec  메모리제한 : 128 MB  Special Judge
//
//문제 설명
//목표 정수 M(>=0)과 N개의 서로 다른 양의 정수가 주어집니다. 이들 정수를 원하는 만큼 합하여 목표 정수를 만드는 경우의 수 중 가장 짧은 경우를 알고 싶습니다. 
//예를 들어 목표 정수가 7이고, [5, 3, 4, 7]이 주어지면 (3, 4), (4, 3), (7) 3개의 답 중에 가장 짭은 답은 (7) 입니다.    
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=1,000)가 주어집니다. 각 테스트케이스마다 첫 줄에는 목표 정수 M(0<=M<=1,000)과 N(2<=N<=100)이 주어집니다. 
//그다음 줄에는 N개의 서로 다른 양의 정수 X(1<=X<=200)가 주어집니다.
//출력 설명
//N개의 정수를 원하는 만큼 합하여 목표 정수를 만들 수 있으면 가장 짧은 길이와 답을 출력하고, 만들 수 없으면 -1를 출력합니다. 
//만약 가장 짧은 길이의 답이 여러 개 존재하면 그 중에 임의의 답을 출력하면 됩니다.


import java.util.Scanner;
import java.util.ArrayList;

public class _D {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 0, T=sc.nextInt(); t < T; t++) {
			
	        int M = sc.nextInt();
	        int N = sc.nextInt();
	        
	        int[] X = new int[N];
	        
	        for (int i=0; i<N; i++) {
	        	X[i] = sc.nextInt();
	        } 
	        
	        ArrayList<Integer> list = bestSum(M, X, new ArrayList<Integer>());
	        if (list != null) {
	        	for(int x: list) {
		        	System.out.print(x+" ");
		        }
	        } else {
	        	System.out.print(-1);
	        }
	        
	        System.out.println();
	        
		}
		
	}
	
	public static ArrayList<Integer> bestSum(int M, int[] X, ArrayList<Integer> memo) {
		
//		if( M < 0) return null;
//		if(M==0) return new ArrayList<Integer>();
//		
////		if(memo.contains(M)) memo.get(M);
//		
//		ArrayList<Integer> best = null;
//		
//		for (int x : X) {
//			ArrayList<Integer> list = bestSum(M-x, X, memo);
//			if (list != null) {
//				if (best==null || best.size() >list.size()+1) {
//					ArrayList<Integer> next = new ArrayList<Integer>();
//					next = list;
//					next.add(x);
//					best=next;
//				}
//			}
//		}
//		
//		memo = best;
//		return best;
//		
		
		ArrayList<ArrayList<Integer>> table = new ArrayList<ArrayList<Integer>>();
		
		for (int i=0;i<M+1;i++) {
			table.add(null);
		}
		
		System.out.println(table.toString());
		
		table.set(0, new ArrayList<Integer>() );
		System.out.println(table.toString());

		for (int i=0; i<M; i++) {
			if (table.get(i) != null) {
				for (int x : X) {
					if(i+x <= M) {
						ArrayList<Integer> best = table.get(i+x);
						if(best == null || best.size() > table.get(i).size() + 1) {
							ArrayList<Integer> next = new ArrayList<Integer>();
							next = table.get(i);
							next.add(x);
							table.set(i+x, next);
						}
						
					}
				}
			}
		}
		
		return table.get(M);
	}
	
}