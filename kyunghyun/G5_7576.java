package BaekJoonGold;

import java.util.*;
import java.io.*;

public class G5_7576 {
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//col
		int M = Integer.parseInt(st.nextToken());
		//row
		int N = Integer.parseInt(st.nextToken());
		
		int map[][] = new int [N][M];

		Queue<Node> que = new LinkedList<>();
	
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j<M; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				
				if(value == 1) {
					que.add(new Node(i, j, 0));
				}
			}
		}
		
		int days = 0;
		
		// 익은 1, 안익은 0, 없음 -1
		while(!que.isEmpty()) {
			Node cur = que.poll();
			days = cur.day;//
			
			for(int i = 0; i<dx.length; i++) {
				int newX = cur.x + dx[i];
				int newY = cur.y + dy[i];
				if(newX >= 0 && newX < N && newY >= 0 && newY < M) {
					if(map[newX][newY] == 0) {
						map[newX][newY] = 1;
						que.add(new Node(newX, newY, cur.day+1));
					}
				}
			}
		}
		
		 if(checkTomato(map, N, M))
	            System.out.println(days);
	        else
	            System.out.println(-1);
	}
	
	private static boolean checkTomato(int [][] map, int N, int M) {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {	
				if(map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static class Node{
		int x;
		int y;
		int day;
		
		public Node(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
}