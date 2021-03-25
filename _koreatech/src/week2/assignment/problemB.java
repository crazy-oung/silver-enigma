package week2.assignment;

//문제 B: 게임판 덮기
//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명
//H*W 크기의 게임판이 있습니다. 게임판은 검은 칸과 흰 칸으로 구성된 격자 모양을 하고 있습니다. 
//주어진 게임판의 흰 칸을 3칸 짜리 L자 모양의 블록으로 덮고 싶습니다. 
//이때 블록은 자유롭게 회전하여 높을 수 있지만, 서로 겹치거나 검은 칸을 덮거나 게임판 밖으로 나가서는 안 됩니다. 다음의 예시입니다.
//게임판이 주어질 때 이를 덮는 방법의 수를 찾아주세요.
//
//
//https://www.algospot.com/judge/problem/read/countSum
//입력 설명
//첫 줄에는 테스트케이스의 수 T(1<=T<=30)가 주어집니다. 
//각 테스트케이스의 첫 줄에는 2개의 정수 H와 W(1<=H, W<=20)가 주어집니다. 
//다음 H 줄에 각 W 글자로 게임판의 모양이 주어집니다. #은 검은 칸, .은 흰 칸을 나타냅니다. 
//입력에 주어지는 게임판에 있는 흰 칸의 수는 50을 넘지 않습니다.
//출력 설명
//주어진 게임판의 흰 칸을 모두 덮는 방법의 수를 출력합니다.
//입력 예시 Copy
//3 
//3 7 
//#.....# 
//#.....# 
//##...## 
//3 7 
//#.....# 
//#.....# 
//##..### 
//8 10 
//########## 
//#........# 
//#........# 
//#........# 
//#........# 
//#........# 
//#........# 
//########## 
//출력 예시 Copy
//0
//2
//1514

import java.util.*;
import java.io.*;

public class problemB {

	// 블록 형태 4가지 
	static int[][][] coverBlock =  new int[][][]{
	    {{0,0},{0,1},{1,0}},	
	    {{0,0},{0,1},{1,1}},
	    {{0,0},{1,0},{1,1}},
	    {{0,0},{1,0},{1,-1}}
	};
	
	public static void main(String[] args) throws IOException  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    	StringTokenizer st = new StringTokenizer(br.readLine()); 
    	
		for (int T = Integer.parseInt(st.nextToken()), i=0; i< T; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			int H = Integer.parseInt(st.nextToken()); // 높 
			int W = Integer.parseInt(st.nextToken()); // 넓 
			
			
			int[][] board = new int[H][W];

			for (int k=0; k <H; k++) {
				String str = br.readLine(); 
				for (int j=0; j < W; j++) {
					board[k][j] = str.charAt(j) == '#'? 1 : 0;
				}
			}// 덮 : 1, 빈칸: 0

			
			System.out.println(countSum(H, W, board));
		}
		br.close();
    }
    

	public static int countSum(int H, int W, int[][] board){

		int y = -1,x= -1; 
		for(int i =0; i<H; i++) { 
			for(int j=0; j<W; j++) { 
				if(board[i][j] == 0) {	 
		            x = j;
		            y = i;
					break; 
				}
			} 
			if(y != -1 ) break; 
		}

		if(y == -1) return 1; 
		
		int count = 0;
		for(int block=0; block<4; block++){
			if (canCover(board,y,x,block, 1)) {
				count += countSum(H,W, board);
			}
	        canCover(board,y,x,block, -1);
	    }
		
		return count;

    }
	
	public static boolean canCover(int[][] board,int y,int x, int blockNum, int onoff) {
		boolean can = true;
		
        for(int i=0;i<3;i++){
            int ny = y + coverBlock[blockNum][i][0];
            int nx = x + coverBlock[blockNum][i][1];
            if(ny < 0 || ny >= board.length
            || nx < 0 || nx >= board[0].length
            )  can = false;
            else if ((board[ny][nx] += onoff) > 1) can = false;     
        }

        
        return can;
	}
	
}