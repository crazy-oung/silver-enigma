package week7;

//문제 B: 마감 시간이 있는 최적 스케줄 짜기
//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명
//마감 시간이 있는 N개의 작업이 주어졌을 때 가장 이득을 최대화하는 스케줄을 찾아주세요.
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=100)가 주어집니다. 
//각 테스트케이스마다 첫 줄에는 작업의 개수 N(1<=N<=1,000)이 주어집니다. 
//그다음 줄에는 마감 시간 D(1<=D<=N/2)와 이득 P(1<=P<=100) 쌍이 N개가 주어집니다. 각 작업의 ID는 1부터 차례로 부여합니다.
//출력 설명
//각 테스트케이스마다 가장 최적 스케줄을 구성하는 타당 집합 S을 작업 ID의 오름차순으로 출력합니다. 
//출력할 때 각 작업 ID 사이에는 공백을 하나 추가합니다.
//입력 예시 Copy
//2
//4
//2 30 1 35 2 25 1 40
//7
//3 40 1 35 1 30 3 25 1 20 3 15 2 10
//출력 예시 Copy
//1 4
//1 2 4

import java.util.*;
import java.util.stream.Collectors;

class Job {
	int id;
    int deadline ;
    int profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

	@Override
	public String toString() {
		return "Job [id=" + id + ", deadline=" + deadline + ", profit=" + profit + "]\n";
	}
    
}


public class _B {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 0, T=sc.nextInt(); t < T; t++) {
			
	        int N = sc.nextInt();
	        
	        List<Job> jobs = new ArrayList<Job>();
	        for (int i=0; i<N; i++) {
	        	jobs.add(new Job(i, sc.nextInt(), sc.nextInt()) );
	        } 
	        
	        jobs = jobs.stream()
		            .sorted((a, b) -> b.profit - a.profit)
		            .collect(Collectors.toList());
	        
	        List<Integer> rs = schedule(jobs, N);
	        
	        for(int i  : rs) {
	            System.out.print(i + " ");
	        }
	        System.out.println();
	        
		}
		
	}

	
	public static List<Integer> schedule(List<Job> jobs, int N) {

	    int[] S = new int[N];
	    List<Integer> rs = new ArrayList<>();
	    
	    for(int i=0; i<jobs.size(); i++) {
	    	for(int j=jobs.get(i).deadline-1; j>=0; j--) {
	    		if (S[j] == 0) {
			    	S[j] = 1;
			    	rs.add(jobs.get(i).id+1);
			    	break;
		    	}
	    	}
	    	
        }

		rs = rs.stream()
	            .sorted((a, b) -> a - b)
	            .collect(Collectors.toList());
	    
	    return rs;
	}
	

}
