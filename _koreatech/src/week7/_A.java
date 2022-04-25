package week7;
//문제 A: LRU Cache
//시간제한 : 1.000 sec  메모리제한 : 128 MB
//
//문제 설명
//가장 오래전에 접근한 페이지를 교체하는 캐시 교체 알고리즘을 구현하여 보자. 이 캐시에는 키와 값 쌍이 저장되며, 저장할 수 있는 키의 개수가 제한되어 있다. 캐시는 put(K, V), get(K) 두 개의 연산을 제공하며, 두 연산을 모두 O(1)에 제공할 수 있어야 합니다. 두 연산은 다음과 같이 동작합니다.
//put(K,V): 키 값 K가 캐시에 존재하면 기존 키 값을 V로 교체함. 키가 존재하지 않으면 가장 오래전에 사용한 키 값을 (K,V)로 교체함
//get(K): 키 값 K가 캐시에 존재하면 그 키에 해당하는 V값을 반환하고, 없으면 -1을 반환함
//입력 설명
//첫 줄에는 테스트케이스 T(1<=T<=100)가 주어집니다. 
//각 테스트케이스마다 첫 줄에는 캐시의 슬롯 수 C(1<=C<=1,000)와 명령 수 N(1<=N<=1,000)이 주어집니다. 
//그다음 줄에는 N개의 명령이 주어집니다. 
//각 명령은 0 또는 1로 시작하며, 0으로 시작하면 정수 2개가 더 주어지며, 1로 시작하면 정수 1개가 더 주어집니다. 
//0 다음에 주어지는 정수 2개는 캐시에 저장해야 하는 키 K(1<=K<=3,000)와 값 V(1<=V<=1,000)이며, 
//1 다음에 주어지는 정수 1개는 캐시에서 읽고자 하는 키 K입니다.
//출력 설명
//각 테스트케이스마다 각 명령을 차례로 실행하였을 때 명령 1들이 반환하는 값을 차례로 출력하여야 합니다. 
//각 값 사이에 하나의 공백이 있어야 합니다.
//입력 예시 Copy
//1
//2 9
//0 1 1 0 2 2 1 1 0 3 3 1 2 0 4 4 1 1 1 3 1 4
//출력 예시 Copy
//1 -1 -1 3 4

//도움
//2 9
//0 1 1 0 2 2 1 1 0 3 3 1 2 0 4 4 1 1 1 3 1 4
//명령 1: 0 1 1
//캐시 [(1:1),_]
//명령 2: 0 2 2
//캐시 [(1:1),(2:2)]
//명령 3: 1 1
//출력: 1
//명령 4: 0 3 3 // 가장 최근에 사용한 키는 1이므로 (2:2)와 교체
//캐시 [(1:1),(3:3)]
//명령 5: 1 2
//출력: -1
//명령 6: 0 4 4 // 가장 최근에 사용한 키는 3이므로 (1:1)와 교체
//캐시 [(4:4),(3:3)]
//명령 7: 1 1
//출력: -1
//명령 8: 1 3
//출력: 3
//명령 9: 1 4
//출력: 4
//get(K), put(K,V)를 하면 K를 사용한 것임

import java.util.*;

class Node {
	int key;
	int value;
	Node prev;
	Node next;
}

class LRUCache {
	
	Node head = new Node();
	Node tail = new Node();
	Map<Integer, Node> nodeMap;
	
	int cache;
	
    public LRUCache(int cache) {
    	nodeMap = new HashMap(cache);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
    	int rs = -1;
    	Node node = nodeMap.get(key);
    	// 앞으로 옮겨서 사용했음
    	if(node != null) {
    		rs = node.value;
    		remove(node);
    		add(node);
    	}
        return 0;
    }
    
    public int put(int key, int value) {
        Node node = nodeMap.get(key);
        if (node != null) {
        	node.value = value;
        	remove(node);
        	add(node);
        	return value;
        } else {
        	// 초과
        	if(nodeMap.size() == cache) {
        		nodeMap.remove(tail.prev.key);
        		remove(tail.prev);
        	}
        	
        	Node node2 = new Node();
        	node2.key = key;
        	node2.value = value;
        	nodeMap.put(key, node2);
        	return -1;
        }
    }
    
    public void add(Node node) {
    	Node headNext = head.next;
    	node.next = headNext;
    	headNext.prev = node;
    	
    	head.next = node;
    	node.prev = head;
    }
    
    public void remove(Node node) {
    	Node nextNode = node.next;
    	Node prevNode = node.prev;
    	
    	nextNode.prev = prevNode;
    	prevNode.next = nextNode;
    }
    
}


public class _A {

	public static void put(int k, ArrayList<Integer> nums) {
		if (nums != null) {
			nums.remove(nums.indexOf(k));
			nums.add(k);
			return;
		} 
		if (nums.isEmpty()) nums.add(k);
	}
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 0, T=sc.nextInt(); t < T; t++) {
			
	        int C = sc.nextInt();
	        int N = sc.nextInt();
	        
	        ArrayList<Integer> nums = new ArrayList<Integer>();
	        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
	        
	        for (int i=0; i<N; i++) {
	        	
	        	
	        	int input = sc.nextInt();
	        	
	        	int k= sc.nextInt();
	        	
	        	if(input == 0) {
	        		int v = sc.nextInt();
	        		boolean isCached = cache.containsKey(k);
        			if (isCached) {
        				cache.put(k, v);
        				put(k, nums);
        			} else if(!isCached) {
        				
        				if(cache.size() == C) {
        					cache.remove(nums.get(0));
        					cache.put(k, v);
        					nums.remove(0);
        					nums.add(k);
        				} else {
        					cache.put(k, v);
            				nums.add(k);
        				}
        			} else if (cache.size() == C) {
        				cache.remove(nums.get(0));
        				nums.remove(0);
        				cache.put(k,v);
                        put(k, nums);
        			}
        			
				} else {
					int rs = -1;
					if(cache.containsKey(k)) {
						rs = cache.get(k);
						put(k,nums);
					}
					
					System.out.print(rs+ " ");
				}
	        	
	        	System.out.println(cache.toString());
	        	System.out.println(nums.toString());
	        	
	        } 
	        System.out.println();
		}
		
	}


}
