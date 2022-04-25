package week11;
//문제 A: 여왕말

//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명
//n x n 서양 체스판에 서로 먹을 수 없도록 n개의 여왕말을 배치하는 문제를 해결하세요. 여왕말은 상하좌우, 대각선으로 이동할 수 있다.
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=9)가 주어지며, 각 테스트케이스마다 체스판의 크기 N(1<=N<=9)이 주어진다.
//출력 설명
//주어진 체스판의 크기에 대해 여왕말 문제를 해결하고, 가능한 모든 해를 X와 Q 문자를 이용하여 차례로 출력하시오. 
//여러 해가 있을 경우 첫 행에 여왕말을 기준으로 가장 왼쪽에 시작하는 해부터 출력하시오. 
//이때 같은 위치에 그다음 행의 여왕말 위치(더 왼쪽에 위치한 해를 우선)를 기준으로 출력하시오. 
//입력 예시 Copy
//3
//2
//1
//4
//출력 예시 Copy
//
//Q
//XQXX
//XXXQ
//QXXX
//XXQX
//XXQX
//QXXX
//XXXQ
//XQXX



import java.util.Scanner;

public class _A {
	static boolean ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 0, T = sc.nextInt(); t < T; t++) {
			ans = false;
			
			int N = sc.nextInt();
			int[] col = new int[N];

			NQueen(col, N);
			if(ans == false) System.out.println();

		}

	}

	static void NQueen(int[] col, int N) {
		int row = 0;
		col[0] = -1;
		
		while (row >= 0) {

			do {
				col[row]++;
			} while ((col[row] < N) && promising(col, row));

			if (col[row] < N) {
				if (row < N - 1)
					col[++row] = -1;
				else
					printBoard(col);
			} else {
				row--;
			}
		}
		
	}
	static boolean promising(int[] col, int row) {
		int x = col[row];
		for (int i = 1; i <= row; i++) {
			int t = col[row - i];
			if (t == x || t == x - i || t == x + i) {
				return true;
			}
		}

		return false;
	}

	public static void printBoard(int[] col) {
	
		for (int y = 0; y < col.length; y++) {
			for (int x = 0; x < col.length; x++) {
				System.out.print(( col[y] == x) ? "Q" : "X");
			}
			System.out.println();
		}
		
		ans = true;
	}

}
