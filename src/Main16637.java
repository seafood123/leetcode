import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16637 {

	public static String[] array;
	public static long val = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		array = new String[N];
		
		String str = br.readLine();
		array = str.split("");
		
		dfs(0,Long.parseLong(array[0]));
		
		System.out.println(val);
		
	}
	
	public static void dfs(int start, long value) {
		if(start +1 >= array.length) {
			//System.out.println("startPoint : "+ start + " -> value : " + value );

			if(val < value) val = value;
			return;
		}
		//System.out.println("startPoint : "+ start + " -> value : " + value );
		
		
		
		long returnVal = 0;
		String cal = array[start+1];
		int next = Integer.parseInt(array[start+2]);
		// 그냥 그 다음 수랑계산하기 
		returnVal = calculate(value,next,cal);
		dfs(start+2,returnVal);
		long nextReturnVal = 0;
		if(start+3 < array.length) {
			// 그다음 괄호를 씌운 후 계산
			String nextCal = array[start+3];
			int next2 = Integer.parseInt(array[start+4]);
			nextReturnVal = calculate(next,next2,nextCal);
			returnVal = calculate(value,nextReturnVal,cal);
			dfs(start+4,returnVal);
		}
		
		
		
	}
	
	public static long calculate(long a, long b, String cal) {
		long value = 0;
		switch(cal) {
		case "+":
			value = plus(a,b);
			break;
		case "-":
			value = minus(a,b);
			break;
		case "*":
			value = multiple(a,b);
			break;
		}
		
		return value;
	}
	
	public static long multiple(long a, long b) {
		return a*b;
	}
	
	public static long plus(long a, long b) {
		return a + b;
	}
	
	public static long minus(long a, long b) {
		return a - b;
	}

}
