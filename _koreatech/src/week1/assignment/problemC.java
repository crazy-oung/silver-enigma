package week1.assignment;

//문제 C: 합병 정렬
//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명
//주어진 N개의 정수를 오름차순으로 정렬하여 주세요. 꼭 합병정렬 구현하여 주세요.

//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=100)가 주어집니다. 각 테스트케이스마다 첫 줄에는 나열되는 정수의 개수 N(1<=N<=10,000)이 주어집니다. 그다음 줄에는 N개의 양의 정수 K(1<=K<=50)가 주어집니다. 

//출력 설명
//각 테스트케이스에 나열된 N개 정수를 오름차순으로 정렬하여 각 숫자를 차례로 출력하여 주세요 숫자와 숫자 사이에는 하나의 공백이 있어야 합니다..

//입력 예시 Copy
//1
//5
//7 1 3 9 5

//출력 예시 Copy
//1 3 5 7 9


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problemC
{

	static long start = 0;
    static long end = 0;
    static long total = 0;
    
    public static void main(String[] args) throws IOException  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		for (int T = Integer.parseInt(br.readLine()), i=0; i< T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] K = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			for (int j = 0; j < N; j ++) {
				K[j] = Integer.parseInt(st.nextToken());
			}

			int[] temp = new int[K.length];
	        mergeSort(K, temp, 0, K.length - 1);
	        
	        for (int k : K) {
	        	System.out.print(k + " ");
	        }
	        System.out.println();
		}
		
		br.close();
    }
    
    public static void mergeSort(int[] arr, int[] temp, int start, int end)
    {
        if (start < end)
        {
            int mid = (start + end) / 2;
            
            mergeSort(arr, temp, start, mid);
            mergeSort(arr, temp, mid + 1, end);
            
            
            for (int i = start; i <= end; i++)
            {
                temp[i] = arr[i];
            }
            
            int part1 = start;
            int part2 = mid + 1;
            int index = start;
            
            while (part1 <= mid && part2 <= end)
            {
            	 arr[index++] = (temp[part1] <= temp[part2])? temp[part1++]: temp[part2++];
            }
            
            for (int i = 0; i <= mid - part1; i++)
            {
                arr[index + i] = temp[part1 + i];
            }
        }
    }
    
}