/*
 * 시작 	:	11시 18분 
 * 끝	:	11시 29분 
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution207 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canFinish(2,new int[][] {{0,1},{1,0}}));
	}
	
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		boolean result = false;
		
		ArrayList<Integer>[] course = new ArrayList[numCourses];
		int[] vertex = new int[numCourses];
		
		int[] temp;
		for(int i=0;i<prerequisites.length;i++) {
			temp = prerequisites[i];
			if(course[temp[1]] == null) {
				course[temp[1]] = new ArrayList<>();
			}
			course[temp[1]].add(temp[0]);
			vertex[temp[0]]++;
		}
		
		LinkedList<Integer> queue = new LinkedList<>();
		for(int i =0;i<vertex.length;i++) {
			if(vertex[i]==0) queue.add(i);
		}
		int nowCourse = 0;
		while(!queue.isEmpty()) {
			nowCourse = queue.poll();
			
			if(course[nowCourse]!=null) {
				for(int i : course[nowCourse]) {
					vertex[i]--;
					if(vertex[i]==0) queue.add(i);
				}
			}
			
		}
		
		for(int i=0;i<vertex.length;i++) {
			if(vertex[i]!=0) return false;
		}
		
		return true;
	}

}
