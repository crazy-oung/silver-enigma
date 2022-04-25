package week12;



//문제 B: 0-1 배낭 채우기
//시간제한 : 1.000 sec  메모리제한 : 256 MB
//
//문제 설명
//가방 하나와 N개의 물건이 주어집니다. 각 물건은 음의 아닌 이득 v와 음의 아닌 크기 w를 가지고, 가방은 용량 W를 가집니다. N개의 물건 중 어떤 물건으로 가방을 채워야 가장 이득이 클까요? 물건은 포함하고나 포함하지 않을 수 있습니다. 물건의 일부만 포함할 수 없습니다.
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=1,000)가 주어집니다. 각 테스트케이스마다 첫 줄에는 가방의 용량 W(1<=W<=100)와 물건의 개수 N(1<=N<=500)이 주어집니다. 그다음 줄에는 N개의 물건에 대해 이득 v(1<=v<=50)와 무게 w(1<=w<=100)가 주어집니다. 첫 물건부터 차례로 0부터 번호를 할당한다.
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
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Item {

	public int profit;
	public int weight;

	public Item(int profit, int weight) {
		this.profit = profit;
		this.weight = weight;
	}

}

class Node implements Comparator

{
	int level;
	int weight;
	int profit;
	double bound;

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}
};

public class _B {

	static boolean[] include, solution;
	static int maxProfit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 0, T = sc.nextInt(); t < T; t++) {

			int W = sc.nextInt();
			int N = sc.nextInt();

			Item[] items = new Item[N];
			include = new boolean[W];
			solution = new boolean[W];
			maxProfit = 0;

			for (int i = 0; i < N; i++)
				items[i] = new Item(sc.nextInt(), sc.nextInt());
			knapsack(items, W, 0);

			System.out.println(maxProfit);

		}

	}

	static double bound(int Weight, int n, Node u, Item items[]) {
		int j, k;
		int totweight;
		float result;

		if (u.weight >= Weight)
			return 0;
		else {
			result = u.profit;
			j = u.level + 1;
			totweight = u.weight;
			while (j <= n && totweight + items[j - 1].weight <= Weight) {
				totweight = totweight + items[j - 1].weight;
				result = result + items[j - 1].profit;
				j++;
			}
			k = j;
			if (k <= n)
				result = result + (Weight - totweight) * items[k - 1].profit / items[k - 1].weight;

			return result;
		}

	}

	static void knapsack(Item[] items, int Weight, int n) {
		PriorityQueue<Node> Q = new PriorityQueue<Node>();

		Node u = new Node(), v = new Node();

		v.level = 0;
		v.profit = 0;
		v.weight = 0;
		v.bound = bound(Weight, n, v, items);

		maxProfit = 0;
		Q.add(v);

		while (!Q.isEmpty()) {

			v = Q.poll();

			Q.remove();

			if (v.bound > maxProfit) {

				u.level = v.level + 1;
				u.weight = v.weight + items[u.level - 1].weight;
				u.profit = v.profit + items[u.level - 1].profit;

				if (u.weight <= Weight && u.profit > maxProfit) {
					maxProfit = u.profit;
				}
				u.bound = bound(Weight, n, u, items);
				if (u.bound > maxProfit) Q.add(u);

				u.weight = v.weight;
				u.profit = v.profit;

				u.bound = bound(Weight, n, u, items);
				if (u.bound > maxProfit) Q.add(u);

			}

		}

	}
}
