package BaekJoonGold;

import java.util.*;
import java.io.*;

public class G5_2589 {
	
	static int map[][];
	static boolean visited[][];
	static int N,M, Answer;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
	public static void main (String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Answer = 0;
		
		//세로 X
		N = Integer.parseInt(st.nextToken());
		//가로 Y
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j=0; j<M; j++) {
				int value = (str.charAt(j) == 'L') ? 1:0;
				map[i][j] = value;			
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1) {
					visited = new boolean [N][M];
					bfs(i, j);
				}
			}
		}
		System.out.println(Answer);
	}
	
	public static void bfs(int x, int y) {
		Queue<Node> que = new LinkedList<>();
		visited[x][y] = true;
 		que.add(new Node(x,y,0));
		
 		while(!que.isEmpty()) {
 			Node now = que.poll();
 			Answer = Math.max(now.count, Answer);
 			
			for(int i = 0; i< dx.length; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if(map[nx][ny] == 1 && visited[nx][ny] != true) {
						visited[nx][ny] = true;
						que.add(new Node(nx,ny,now.count+1));
					}
				}		
			}		
 		}
	}
	
	public static class Node{
		int x;
		int y;
		int count;
		
		public Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}
