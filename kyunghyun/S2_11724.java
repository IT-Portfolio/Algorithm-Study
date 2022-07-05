package BaekJoonSilver;

import java.util.*;
import java.io.*;

public class S2_11724 {
	static ArrayList<ArrayList<Integer>> map;
	static boolean visited[];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		visited = new boolean [N+1];
		
		map = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i <N+1; i++) {
			map.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map.get(x).add(y);
			map.get(y).add(x);
		}
		
		int count = 0;
		
		for(int i = 1; i < N+1; i++) {
			//if?
			if(visited[i] != true) {
				dfs(i);
				count++;
			}
		}		
		System.out.println(count);
	}
	
	public static void dfs(int x) { 
		visited[x] = true;
		//for?
		for(int e : map.get(x)) {
			if(visited[e] != true) {
				dfs(e);
			}
		}		
	}
}
