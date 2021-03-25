package week1.assignment;



//문제 A: 중복 존재
//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명
//중복된 카드가 있는지 여부
//입력 설명
//첫 줄에는 테스트케이스의 수 T가 주어집니다. 다음줄부터는 각 테스트케이스마다 포켓몬 카드의 수 N(32비트 정수)이 주어지며, 포켓몬 카드를 나타내는 N개의 정수가 주어진다.
//출력 설명
//중복된 카드가 존재하면  true를 없으면 false를 출력하시오.
//입력 예시 
//2
//5
//5 4 7 1 4
//4
//1 2 3 4
//출력 예시
//true
//false

//A 문제는 집합 자료구조를 이용하여 해결해야 합니다.
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problemA
{
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		for (int T = Integer.parseInt(br.readLine()), i=0; i< T; i++) {
			int N = Integer.parseInt(br.readLine());
			HashSet NSet = new HashSet();
			
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			for (int j = 0; j < N; j ++) {
				NSet.add(Integer.parseInt(st.nextToken()));
			}
			
			System.out.println( (NSet.size() != N)? true : false);
		}
		br.close();
	}
}