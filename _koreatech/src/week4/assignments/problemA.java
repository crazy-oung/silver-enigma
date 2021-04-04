package week4.assignments;

//사용하는 언어의 랜덤 발생기를 이용하여 피봇으로 사용할 값의 위치를 결정하도록 빠른 정렬를 구현하세요.
//
//랜덤한 데이터가 들어오면 랜덤 발생기를 사용하지 않고 첫번째 요소를 피봇으로 사용하여도 
//성능에 문제가 없을 것으로 생각할 수 있지만 
//랜덤 발생기를 이용하여 피봇 위치를 결정하면 어떤 형태의 입력 데이터도 효과적으로 처리할 수 있습니다.
//
//문제 A: 정렬
//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명
//주어진 N개의 정수를 오름차순으로 정렬하여 주세요. 
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=100)가 주어집니다. 
//각 테스트케이스마다 첫 줄에는 나열되는 정수의 개수 N(1<=N<=10,000)이 주어집니다. 그다음 줄에는 N개의 양의 정수 K(1<=K<=50)가 주어집니다. 
//출력 설명
//각 테스트케이스에 나열된 N개 정수를 오름차순으로 정렬하여 각 숫자를 차례로 출력하여 주세요 
//숫자와 숫자 사이에는 하나의 공백이 있어야 합니다..
//입력 예시 
//1
//5
//7 1 3 9 5
//출력 예시 
//1 3 5 7 9

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problemA {

	static int[] K = null;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner in = new Scanner(System.in);
		
		for(int T = Integer.parseInt(br.readLine()),t=0; t< T; t++) {
			
			int N = Integer.valueOf(in.nextLine()).intValue();
			K = new int[N];
			
			String[] input = in.nextLine().split(" "); 
			for(int i =0; i<N ; i++) {
				K[i] = Integer.valueOf(input[i]).intValue();
			}
			
			quickSort(0, K.length-1);
			printArr(K);
			
		}
		
	}
	
	

	static void quickSort(int l, int r) {
		if (l >= r) return;
		
		choosePivot(l,r);
        int mid = partition(l, r);
        quickSort(l, mid - 1);
        quickSort(mid + 1, r);
	}
	static int partition(int l, int r) {
        int p = K[l];
		int i = l+1;
		
		for(int j=l+1; j<=r; j++) {
			if (K[j] < p) {
				swap(i, j);
				++i;
			}
		}
		swap(l, i-1);
		return i-1;
		
	}
	
	private static void swap(int i, int j) {
        int tmp = K[i];
        K[i] = K[j];
        K[j] = tmp;
        
    }
	
	private static void choosePivot(int l, int r) {
		int randnum = (int) ((Math.random() * (r - l)) + l); // l~r
		swap(randnum, l);
	}

    public static void printArr(int[] K) {
		if (K == null) {
			
		} else {
			for (int i =0; i<K.length; i++) {
				System.out.print(K[i]+" ");
			}
			System.out.println();
		}
	}
}