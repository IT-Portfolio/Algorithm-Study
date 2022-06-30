package dongyoon;

import java.util.*;
import java.util.stream.*;
import java.io.*;

class Node implements Comparable<Node> {
    int end, dist; // 목적지, 거리
    
    public Node(int end, int dist) {
        this.end = end;
        this.dist = dist;
    }
    
    @Override
    public int compareTo(Node n) {
        if (this.dist == n.dist) return this.end - n.end;
        return this.dist - n.dist; // 거리 우선 오름차순 기준정렬
    }
}

public class BOJ1238 {
    private static final int MAX_VERTEX = 1001; // 최대 노드 수
    private static int N, M, X;
    private static List<Node>[] adj = new ArrayList[MAX_VERTEX];
    private static final int INF = Integer.MAX_VALUE; 
    
    private static int dijkstra(int start, int end) {
        List<Integer> dist = Stream.generate(() -> INF).limit(N + 1).collect(Collectors.toList()); // 거리 무한대로 초기화
        dist.set(start, 0);
        
        PriorityQueue<Node> pq = new PriorityQueue<>(); // reverseOrder 미 선언시 최소힙
        pq.add(new Node(start, 0)); // (노드번호, 거리) 쌍으로 입력 
        
        while(!pq.isEmpty()) {
            Node n = pq.poll();
            int node = n.end;
            int nodeDistance = n.dist;
            
            for (int i = 0; i < adj[node].size(); i++) {
                int nextNode = adj[node].get(i).end;
                int nextNodeDistance = nodeDistance + adj[node].get(i).dist;
                
                if (dist.get(nextNode) > nextNodeDistance) { // 최소 거리 선택
                    dist.set(nextNode, nextNodeDistance);
                    pq.add(new Node(nextNode, nextNodeDistance));
                }
            }
        }
        
        return dist.get(end);
    }
    
	public static void main(String[] args) throws IOException {
	    int answer = 0;
	    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    X = Integer.parseInt(st.nextToken());
	    
	    for (int i = 0; i < MAX_VERTEX; i++)
	        adj[i] = new ArrayList<>();
	    
	    for (int i = 0; i < M; i++) {
	        st = new StringTokenizer(br.readLine());
	        
	        int start, end, dist;
	        
	        start = Integer.parseInt(st.nextToken());
	        end = Integer.parseInt(st.nextToken());
	        dist = Integer.parseInt(st.nextToken());
	        
	        adj[start].add(new Node(end, dist));
	    }
	    
	    for (int i = 1; i <= N; i++) 
	        answer = Math.max(answer, dijkstra(i, X) + dijkstra(X, i));
	        
	    System.out.println(answer);
	    
		br.close();
	}
}
