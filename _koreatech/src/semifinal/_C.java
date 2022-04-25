package semifinal;

import java.util.Scanner;
import java.util.ArrayList;

//문제 C: 행성 충돌
//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명
//일렬로 나열된 정수로 표현되는 행성들이 주어집니다. 주어진 정수의 절대값이 행성의 크기를 나타내고, 부호가 행성의 이동 방향을 나타냅니다. 
//양수이면 오른쪽으로 이동하고, 음수이면 왼쪽으로 이동합니다. 모든 행성은 같은 속도로 이동한다고 가정합니다. 두 행성이 충돌하면 작은 크기의 행성은 폭파하여 사라집니다. 
//두 행성의 크기가 같으면 둘 다 폭파합니다. 같은 방향으로 이동하는 행성은 절대 충돌하지 않습니다. 주어진 일련의 행성이 주어졌을 때 모든 충돌이 일어난 후 남은 행성이 어떻게 되는지 알려주세요. 
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=100)가 주어집니다. 
//각 테스트케이스마다 첫 줄에는 행성의 개수 N(2<=N<-10,000)가 주어집니다. 
//그다음 줄에는 N개의 행성을 나타내는 정수 A(-1,000<=A<=1,000)가 주어집니다. 행성의 값으로 0은 주어지지 않습니다.
//출력 설명
//각 테스트케이스마다 모든 충돌이 일어난 후에 남은 행성들을 출력하여 주세요.
//입력 예시 Copy
//4
//3
//5 10 -5
//2
//8 -8
//3
//10 2 -5
//4
//-2 -1 1 2
//출력 예시 Copy
//5 10
//
//10
//-2 -1 1 2
public class _C {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 0, T = sc.nextInt(); t < T; t++) {
			int N = sc.nextInt();
			
			int[] A = new int[N];
			for (int i=0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			
			
			ArrayList<Integer> rs = solution(A);
			if(rs.size() != 0) {
				for(int i: rs) {
					System.out.print(i + " ");
				}
				System.out.println();
			} else {
				System.out.println();
				
			}
		}

	}
	
	public static ArrayList<Integer> solution(int[] A) {
		ArrayList<Integer> rs = new ArrayList<Integer>();
		rs.add(A[0]);
		int rsc =0;
		for (int i = 1; i < A.length; i++) {
			if((rs.get(rsc) > 0 && A[i] >0) || (rs.get(rsc) < 0 && A[i] < 0)) {
				rs.add(A[i]);
				rsc++;
			} else {
				boolean rsFlag = (rs.get(rsc) >0 );
				boolean AFlag = ( A[i] >0 );
				
				if ( rsFlag  != AFlag) {
					if(rsFlag == false && AFlag == true) {
						rs.add(A[i]);
						rsc++;
					} else if( Math.abs(rs.get(rsc)) <  Math.abs(A[i])) {
						rs.set(rsc, A[i]);

						for(int j=rsc;j<=1;j--) {
							if ( Math.abs(rs.get(rsc)) <  Math.abs(A[i])) {
								rs.set(j-1, rs.get(j));
								rs.remove(j);
							}
						}
					} else if ( Math.abs(rs.get(rsc)) ==  Math.abs(A[i])) {
						rs.remove(rsc--);
					}
					
				} 
			}
			
		}

		

		return rs;
	}
}
