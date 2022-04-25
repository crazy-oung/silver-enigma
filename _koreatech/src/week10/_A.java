package week10;

//문제 A: 유전자 염기서열 유사성
//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명
//A, C, G, T 4개의 문자로 구성된 두 개의 문자열 X와 Y가 주어지고, 불일치 패널티 M, 공백 패널티 G가 주어졌을 때 패널티 점수가 최소화되는 배치를 찾아주세요.
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=1,000)가 주어집니다. 
//각 테스트케이스는 공백 패널티 G(1<=G<=10), 불일치 패널티 M(1<=M<=10), 문자열 X와 문자열 Y가 주어집니다. 각 문자열의 길이는 1부터 최대 100까지입니다.
//출력 설명
//각 테스트케이스마다 전체 패널티 점수가 최소화되는 배치를 찾고 그때 점수를 출력하여 주새요.
//입력 예시 Copy
//1
//2 1 AGTACG ACATAG
//출력 예시 Copy
//4


import java.util.Scanner;

public class _A {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 0, T=sc.nextInt(); t < T; t++) {
			
			int G = sc.nextInt();
	        int M = sc.nextInt();
	        
	        String X = sc.next();
	        String Y = sc.next();

	        System.out.println(sequenceAlignment(X, Y, G, M));
	        
		}
		
	}
	
	public static int sequenceAlignment(String X, String Y, int G, int M) {
//		int i, j; // intialising variables
//	      
//	    int m = x.length(); // length of gene1
//	    int n = y.length(); // length of gene2
//	      
//	    // table for storing optimal
//	    // substructure answers
//	    int dp[][] = new int[n + m + 1][n + m + 1];
//	      
//	    for (int[] x1 : dp)
//	    Arrays.fill(x1, 0);
//	  
//	    // intialising the table 
//	    for (i = 0; i <= (n + m); i++)
//	    {
//	        dp[i][0] = i * pgap;
//	        dp[0][i] = i * pgap;
//	    } 
//	  
//	    // calcuting the 
//	    // minimum penalty
//	    for (i = 1; i <= m; i++)
//	    {
//	        for (j = 1; j <= n; j++)
//	        {
//	            if (x.charAt(i - 1) == y.charAt(j - 1))
//	            {
//	                dp[i][j] = dp[i - 1][j - 1];
//	            }
//	            else
//	            {
//	                dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1] + pxy , 
//	                                             dp[i - 1][j] + pgap) , 
//	                                             dp[i][j - 1] + pgap );
//	            }
//	        }
//	    }
//	  
//	    // Reconstructing the solution
//	    int l = n + m; // maximum possible length
//	      
//	    i = m; j = n;
//	      
//	    int xpos = l;
//	    int ypos = l;
//	  
//	    // Final answers for 
//	    // the respective strings
//	    int xans[] = new int[l + 1]; 
//	    int yans[] = new int[l + 1];
//	      
//	    while ( !(i == 0 || j == 0))
//	    {
//	        if (x.charAt(i - 1) == y.charAt(j - 1))
//	        {
//	            xans[xpos--] = (int)x.charAt(i - 1);
//	            yans[ypos--] = (int)y.charAt(j - 1);
//	            i--; j--;
//	        }
//	        else if (dp[i - 1][j - 1] + pxy == dp[i][j])
//	        {
//	            xans[xpos--] = (int)x.charAt(i - 1);
//	            yans[ypos--] = (int)y.charAt(j - 1);
//	            i--; j--;
//	        }
//	        else if (dp[i - 1][j] + pgap == dp[i][j])
//	        {
//	            xans[xpos--] = (int)x.charAt(i - 1);
//	            yans[ypos--] = (int)'_';
//	            i--;
//	        }
//	        else if (dp[i][j - 1] + pgap == dp[i][j])
//	        {
//	            xans[xpos--] = (int)'_';
//	            yans[ypos--] = (int)y.charAt(j - 1);
//	            j--;
//	        }
//	    }
//	    while (xpos > 0)
//	    {
//	        if (i > 0) xans[xpos--] = (int)x.charAt(--i);
//	        else xans[xpos--] = (int)'_';
//	    }
//	    while (ypos > 0)
//	    {
//	        if (j > 0) yans[ypos--] = (int)y.charAt(--j);
//	        else yans[ypos--] = (int)'_';
//	    }
//	  
//	    int id = 1;
//	    for (i = l; i >= 1; i--)
//	    {
//	        if ((char)yans[i] == '_' && 
//	            (char)xans[i] == '_')
//	        {
//	            id = i + 1;
//	            break;
//	        }
//	    }
//	  
//	    // Printing the final answer
//	    System.out.print("Minimum Penalty in " + 
//	                     "aligning the genes = ");
//	    System.out.print(dp[m][n] + "\n");
//	    System.out.println("The aligned genes are :");
//	    for (i = id; i <= l; i++)
//	    {
//	        System.out.print((char)xans[i]);
//	    }
//	    System.out.print("\n");
//	    for (i = id; i <= l; i++)
//	    {
//	        System.out.print((char)yans[i]);
//	    }
//	    return;
		
		int[][] table = new int[X.length() + 1][Y.length() + 1];
		for (int i = 0; i < X.length(); i++) {
			table[i][0] = i * M;
		}
		for (int i = 0; i < Y.length(); i++) {
			table[0][i] = i * M;
		}
		for (int i = 1; i <= X.length(); i++) {
			{
				for (int j = 1; j <= Y.length(); j++) {
					if (X.charAt(i - 1) == Y.charAt(j - 1)) {
						table[i][j] = table[i - 1][j - 1];
					} else {
						table[i][j] = Math.min(Math.min(table[i - 1][j - 1] + G, table[i - 1][j] + M),
								table[i][j - 1] + M);
					}
				}
			}
		}
	   
		
		return table[X.length()][Y.length()];
	   
	}
	
	
}
