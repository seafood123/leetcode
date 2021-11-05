import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

class Solution_day7 {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"));
	}
	/*
	public static int lengthOfLongestSubstring(String s) {
		int result = 0;
		if(s.equals("")) return 0;
		String[] arr = s.split("");
		int index = 0;
		LinkedList<String> list = new LinkedList<>();
		String now = "";
		int duplicate = 0;
		while (index < arr.length) {
			now = arr[index];
			if (list.contains(now)) {
				result = Math.max(list.size(), result);
				duplicate = list.indexOf(now);
				for (int i = 0; i <= duplicate; i++)
					list.poll();

			}
			list.add(now);
			index++;
		}
		result = Math.max(list.size(), result);
		return result;

	}
	*/
	
	public static int lengthOfLongestSubstring(String s) {
		int result = 0;
		int length=0;
		for(char a : s.toCharArray()) {
			length = Math.max(length, a);
		}
		int[] index = new int[length+1];
		Arrays.fill(index, -1);
		if(s.equals("")) return 0;
		
		int start = 0;
		int end = 0;
		int now = 0;
		while(start < s.length() && end < s.length()) {
			
			now = s.charAt(end);
			if(index[now] == -1) index[now] = end;
			else {
				result = Math.max(result, end-start);
				start = (start >index[now]+1)? start : index[now]+1;
				index[now] = end;
			}
			end++;
		}
		result = Math.max(result, end-start);
		return result;

	}
}