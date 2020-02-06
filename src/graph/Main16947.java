package graph;

import java.io.*;
import java.util.*;
public class Main16947 {
	static int N;
	static int dist[];
	static int visited[];
	static ArrayList<Integer> arr[];
	// 0 : 탐색 진행 x, 1 : 탐색했지만 순환은 아님, 2: 탐색했는데 순환
	static boolean dfs(int pre, int cur) {
		boolean result = false;
		
		for(int n : arr[cur]) {
			if(n == pre) continue;
			if(visited[n] == 0) {
				visited[n] = 1;
				result = dfs(cur, n);
				if(result) {
					if(visited[cur] == 2) return false;
					else {
						visited[cur] = 2;
						return true;
					}
				}
			}else if(visited[n] == 1) { 	// 이전에 탐색한 곳으로 돌아옴
				visited[n] = 2;
				visited[cur] = 2;
				return true;
				
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dist = new int[N+1];
		arr = new ArrayList[N+1];
		visited = new int[N+1];
		for(int i = 1 ; i <= N ; i++) arr[i] = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[u].add(v);
			arr[v].add(u);
		}
		Queue<Integer> q = new LinkedList<>();
		visited[1] = 1;
		dfs(0,1);
		for(int i = 1 ; i <= N ; i++) {
			if(visited[i] == 2) {
				dist[i] = 1;
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int p = q.poll();
			for(int y : arr[p]) {
				if(dist[y] == 0) {
					dist[y] = dist[p] + 1;
					q.add(y);
				}
			}
		}
		
		for(int i = 1 ; i <= N ; i++) System.out.print(dist[i]-1 + " ");
		
	}

}
