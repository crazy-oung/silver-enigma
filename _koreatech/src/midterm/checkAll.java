package midterm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

public class checkAll {
	
	
	
//	 max = MIN
//			 for i = 1 to A.length do
//			 sum = 0
//			 for j = i to A.length do
//			 sum += A[j]
//			 max = max(sum, max) return max
	
	
	//  종료조건.
	//	1) picked의 포함된 수의 개수
	//	2) 다음에 삽입할 값이 N보다 작아야 함
	//	다음에 삽입할 값. picked 마지막 값+1
	void pick1(Vector<Vector<Integer>> result, int N, int M, Vector<Integer> picked){
		if(M==0){ 
			result.add(picked); 
			return; 
		}
		int smallest = picked.size() == 0? 0: picked.get(picked.size()-1)+1; 
		
		for(int next=smallest; next<N; next++){
			picked.add(next); 
			pick1(result, N, M-1, picked); 
			picked.remove(picked.size()-1);
		} 
	}
	void pickMfromN1(int N, int M){
		Vector<Vector<Integer>> totalCombination = null; 
		Vector<Integer> picked = null;
		pick1(totalCombination, N, M, picked);
	}
	
	//	종료조건.
	//	1) index
	//	2) 다음에 삽입할 값이 N보다 작아야 함
	//	다음에 삽입할 값. i
	void pick2(Vector<Vector<Integer>> result,
		int N, int M, int index, int i,
		Vector<Integer> picked){
		if(M==index){ result.add(picked); return; } if(i>=N) return;
		picked.set(index, i);
		pick2(result, N, M, index+1, i+1, picked); 
		pick2(result, N, M, index, i+1, picked);
	}
	void pickMfromN2(int N, int M){ 
		Vector<Vector<Integer>> totalCombination = null; 
		Vector<Integer> picked = null; // 사이즈가M이고 0으로 초기
		pick2(totalCombination, N, M, 0, 0, picked);
	}
			
			 
			
			
	
	
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
	
	
	  public static List bestSum(int M, int[] X) {
	        if (M<0) return null;
	        if (M==0) return new ArrayList();
	         
	        List best = null;
	        for (int i=0; i < X.length; i++) {
	            list = bestSum(M-X[i], X);
	            if (list != null) {
	                if(best == null || best.size() > list.size()+1) {
	                    list.add(X[i]);
	                    best = list;
	                }
	            }
	        }
	         
	        return best;
	    }
	  
	 public static boolean canSum(int N, int[] X) {
        if (N<0) return false;
        if (N==0) return true;
         
        for (int i=0; i<X.length; i++) {
            if (canSum(N-X[i], X)) return true;
        }
        return false;
    }
	 
	 public static int countSum(int N, int[] X) {
	        if (N<0) return 0;
	        if (N==0) return 1;
	        int count = 0;
	        for (int i=0; i<X.length; i++) {
	            count += countSum(N-X[i], X);
	        }
	        return count;
	    }
	 
	 static List list = new ArrayList();
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
	 
	 public static List howSum2(int M, int[] X) {
        if (M<0) return null;
        if (M==0) return new ArrayList<Integer>();
         
        for (int i=0; i<X.length; i++) {
        	List list = howSum2(M-X[i], X);
            if (list != null) {
                list.add(X[i]);
                return list;
            }
        }
        return null;
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
