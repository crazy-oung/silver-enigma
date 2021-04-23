package midterm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class divideConcour {
	public static int[] arr = { 5, 7, 10, 12, 16, 20, 21, 25, 28, 30 };

	public static int binarySearch(int target) {
		int low = 0;
		int high = arr.length;
		while (low <= high) {
			int middle = (low + high) / 2;
			if (target == arr[middle]) {
				return middle;
			} else if (target > arr[middle]) {
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		return -1; // not found
	}

	public int max(int[] arr, int low, int high) {
		int m, left, right;
		m = (low + high) / 2;
		if (low == high)
			return arr[low];
		left = max(arr, low, m);
		right = max(arr, m + 1, high);
		return (left > right) ? left : right;
	}

	public static String reverseQuadTree(String str) {
		char firstChar = str.charAt(0);
		if (firstChar != 'x')
			return String.valueOf(firstChar);

		int index = 1; // 첫 문자 x를 제외하기 위해

		// 4등분시 왼쪽 위 조각
		String leftTop = reverseQuadTree(str.substring(index));
		// 4등분시 오른쪽 위 조각
		index += leftTop.length();
		String rightTop = reverseQuadTree(str.substring(index));
		// 4등분시 왼쪽 아래 조각
		index += rightTop.length();
		String leftBottom = reverseQuadTree(str.substring(index));
		// 4등분시 오른쪽 아래 조각
		index += leftBottom.length();
		String rightBottom = reverseQuadTree(str.substring(index));
		return "x" + leftBottom + rightBottom + leftTop + rightTop;

	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < C; i++) {
			String testCase = br.readLine();
			System.out.println(reverseQuadTree(testCase));
		}
	}
	
	
	public static void mergeSort(int[] data, int p, int r){
        int q; // 중간값
        if (p < r){ // 배열의 원소의 수가 2개 이상이라면
            q = (p+r)/2; // 소수점 내림
            mergeSort(data, p, q); //절반
            mergeSort(data, q+1, r); // 남은 절반
            merge(data, p, q, r); // 합병 수행
        }
    }

    public static void merge(int[] data, int p, int q, int r){ // 합병을 수행하는 과정 시작, 중간, 마지
        int i = p; // 시작위치
        int j = q+1; // 중간다음
        int k = p; // 시작위치

        int[] temp = new int[data.length]; // 새로운 임시저장공간

        while (i <= q && j <= r){
            if (data[i] <= data[j]){
                temp[k++] = data[i++];
            }
            else{
                temp[k++] = data[j++];
            }
        }

        while(i <= q){ temp[k++] = data[i++]; }
        while(j <= r){ temp[k++] = data[j++]; }

        for (int a = p; a <= r; a++){
            data[a] = temp[a];
        }
    }
}
