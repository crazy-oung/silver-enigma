package week3;


//문제 C: 평면좌표계에서 가장 가까운 좌표쌍 찾기
//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명
//주어진 N개의 평면 좌표 중 가장 가까운 좌표를 찾아주세요.
//두 좌표 간 거리는 유크리드 거리를 통해 계산합니다. 즉, 좌표 p가 (a, b)이고, 좌표 q가 (c, d)이면 유크리드 거리 d(p, q) = ((a-c)2+(b-d)2)1/2입니다.
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=100)가 주어집니다. 
//각 테스트케이스마다 첫 줄에는 좌표의 수 N(1<=N<=2,500)이 주어집니다. 
//그다음 줄에는 N개의 좌표 (x(-10,000<=x<=10,000, y(-10,000<=y<=10,000))가 주어집니다. 
//출력 설명
//각 테스트케이스마다 가장 가까운 좌표 쌍간 거리를 소수점 2자리까지 출력하여 주세요. 
//입력 예시
//1
//3
//1 0 2 0 5 0
//출력 예시
//1.00


import java.util.*;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problemC
{	
   
    
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		for (int T = Integer.parseInt(br.readLine()), i=0; i< T; i++) {
			
			int N = Integer.parseInt(br.readLine());
			List<Point> points = new ArrayList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				points.add(new Point(x, y));
			}
			
			Collections.sort(points, (p1, p2) -> p1.x - p2.x);
			System.out.println(closestPair(points, 0, points.size()-1));

		}
		
		br.close();
    	
		
	}


	public static double closestPair(List<Point> points, int start, int end) {
		
		if ( end - start + 1 <= 3) return bruteForce(points, start, end);
		
		int mid = (start + end) / 2;
		double d = Math.min(closestPair(points, start, mid), closestPair(points, mid + 1, end));
		
		List<Point> temp = new ArrayList<>();
		for (int i = start; i <= end; i++) {
			int t = points.get(mid).x - points.get(i).x;
			if (Math.pow(t, 2) < d) temp.add(points.get(i));
		}
		
		Collections.sort(temp, (p1, p2) -> p1.y - p2.y);
		for (int i = 0; i < temp.size() - 1; i++) {
			for (int j = i + 1; j < temp.size(); j++) {
				int t = temp.get(j).y - temp.get(i).y;

				if (Math.pow(t, 2) < d)  d = Math.min(d, euclideanDistance(temp.get(i), temp.get(j)) );
				else break;
			}
		}

		return d;
	}
	
	static double bruteForce(List<Point> points, int start, int end) {
		double min = Integer.MAX_VALUE;
		for (int i = start; i < end; i++) {
			for (int j = i + 1; j <= end; j++) {
				double k = euclideanDistance(points.get(i), points.get(j));
				min = Math.min(k, min);
			}
		}

		return min;
	}
	
	public static double euclideanDistance(Point p, Point q) {
		return Math.sqrt(Math.pow(p.x - q.x, 2) +  Math.pow(p.y - q.y,2));
	}
	
 
  

}
