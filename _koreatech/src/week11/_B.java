package week11;
//문제 B: 0-1 배낭 채우기

//시간제한 : 1.000 sec  메모리제한 : 256 MB
//
//문제 설명
//가방 하나와 N개의 물건이 주어집니다. 각 물건은 음의 아닌 이득 v와 음의 아닌 크기 w를 가지고, 가방은 용량 W를 가집니다. 
//N개의 물건 중 어떤 물건으로 가방을 채워야 가장 이득이 클까요? 물건은 포함하고나 포함하지 않을 수 있습니다. 물건의 일부만 포함할 수 없습니다.
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=1,000)가 주어집니다. 
//각 테스트케이스마다 첫 줄에는 가방의 용량 W(1<=W<=100)와 물건의 개수 N(1<=N<=500)이 주어집니다. 
//그 다음 줄에는 N개의 물건에 대해 이득 v(1<=v<=50)와 무게 w(1<=w<=100)가 주어집니다. 첫 물건부터 차례로 0부터 번호를 할당한다.
//출력 설명
//각 테스트케이스마다 주어진 물건으로 가방을 채웠을 때 얻을 수 있는 가장 큰 이득을 출력해 주세요.
//입력 예시 Copy
//2
//6 4
//3 4 2 3 4 2 4 3
//30 3
//4 10 4 10 10 25
//출력 예시 Copy
//8
//10

import java.util.Scanner;

class Item {
	
	public int profit;
	public int weight;
	
	public Item(int profit, int weight) {
		this.profit = profit;
		this.weight = weight;
	}
	
}

public class _B {
	
	static boolean[] include, solution;
	static int maxProfit;
	
	public static boolean promising(Item[] items, int W, int currProfit, int currWeight,  int index) {
		if (currWeight >= W)
			return false;

		int n = items.length;
		int nextIndex = index + 1;
		int bound = currProfit;
		int totalWeight = currWeight;
		
		while (nextIndex < n && totalWeight + items[nextIndex].weight <= W) {
			totalWeight += items[nextIndex].weight;
			bound += items[nextIndex].profit;
			nextIndex++;
		}
		
		if (nextIndex < n) {
			bound += (W - totalWeight) * (items[nextIndex].profit / items[nextIndex].weight);
		}
		return bound > maxProfit;

	}

	
	static void knapsack(Item[] items, int W, int currProfit, int currWeight, int index) {
		if (currWeight<=W && currProfit>maxProfit) {
			maxProfit = currProfit;
			solution = include;
		}
		
		if (promising(items, W, currProfit, currWeight, index)) {
			include[index+1] = true;
			knapsack(items, W, currProfit+items[index+1].profit, currWeight+items[index+1].weight, index+1); 
			include[index+1] = false;
			knapsack(items, W, currProfit, currWeight, index+1);
		}
				
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 0, T = sc.nextInt(); t < T; t++) {

			int W = sc.nextInt();
			int N = sc.nextInt();

			Item[] items = new Item[N];
			include = new boolean[W];
			solution = new boolean[W];
			maxProfit =0;
			
			for (int i = 0; i < N; i++) items[i] = new Item(sc.nextInt(), sc.nextInt());
			knapsack(items, W, 0, 0, 0);
			
			System.out.println(maxProfit);

		}

	}
	
}



//
//static int knapSack(int W, int wt[], int val[], int n) {
//	
//	if (n == 0 || W == 0) return 0;
//
//	if (wt[n - 1] > W) return knapSack(W, wt, val, n - 1);
//
//	else return Math.max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1), knapSack(W, wt, val, n - 1));
//}
//
//static int W, maxprofit=0, bound;
//static int numbest;
//
//static boolean[] bestset, include, p,w;
//static void knapsack (int index, int i, int profit, int weight) {
//	if (weight <= W && profit > maxprofit) { 
//		maxprofit = profit;
//		numbest = i; 
//		bestset = include; 
//	}
//    
//	if (promising(i, profit, weight)) {
//		include[i+1] = true; 
//		knapsack(i+1, profit+p[i+1], weight+w[i+1]);
//		include[i+1] = false; 
//		knapsack(i+1, profit, weight);
//	}
//}
// 
//
//static boolean promising(int index, int i, int profit, int weight) {
//	index j, k; 
//	int totweight; 
//	float bound;
//	if (weight >= W) return false;  //자식마디로 확장할 수 있을 때만 유망하다.
//	else {							//자식마디에 쓸 공간이 남아 있어야 한다. 
//		j = i+1;
//	bound = profit; 
//	totweight = weight;
//	while ((j <= n) && (totweight +w[j] <= W)) {  //가능한 많은 아이템을 취한다. 
//		totweight = totweight + w[j]; 
//		bound = bound + p[j];
//		j++;
//	}
//	k=j;  		
//	if (k <= n)  // k째 아이템의 일부분을 취함
//		bound = bound +(W–totweight)*p[k]/w[k];
//	
//    return bound > maxprofit;
//}
//}



//
//public static void knapsack(int[] weights, int[] values, int max, int index, int[] sol, int[] fin) {
//	sol[index] = -1;
//	int n = weights.length;
//	while (sol[index] < 1) {
//		sol[index] = sol[index] + 1;
//		if (sum(index, sol, weights) <= max && index == n - 1) {
//			update(weights, values, max, index, sol, fin);
//		} else if (index < n - 1) {
//			knapsack(weights, values, max, index + 1, sol, fin);
//
//		}
//
//	}
//
//}
//
//private static int sum(int index, int[] weights, int[] sol) {
//	int res = 0;
//
//	for (int i = 0; i < sol.length; i++) {
//		if (sol[i] < 0)
//			System.out.println("in sum: i = " + i + "   sol[i] = " + sol[i]);
//		res += sol[i] * weights[i];
//	}
//	return res;
//}
//
//private static void update(int[] weights, int[] values, int max, int index, int[] sol, int[] fin) {
//
//	int totalValue = 0;
//	int totalWeight = 0;
//
//	for (int i = 0; i < weights.length; i++) {
//		if (sol[i] == 1) {
//			totalValue += values[i];
//			totalWeight += weights[i];
//		}
//	}
//
//	if (totalValue > val) {
//		for (int i = 0; i < weights.length; i++) {
//			fin[i] = sol[i];
//		}
//		val = totalValue;
//		wei = totalWeight;
//
//	}
//
//}
