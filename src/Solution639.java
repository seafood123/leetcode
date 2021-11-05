import java.util.Arrays;

public class Solution639 {
    public static int numDecodings(String s) {
        int MOD = 1000000007;
        String[] arr = s.split("");
        long[] dp = new long[arr.length+1];
        dp[0] = 1;
        int cnt = 0;

        if(arr[0].equals("0")) return 0;
        if(arr[0].equals("*")) {
            dp[1] = 9;
        }else {
            dp[1] = 1;
        }

        long point = 0;
        String cut = "";
        int num = 0;
        for(int i=1;i<arr.length;i++) {
            point = 0;
            // 우선 내가 *이라면
            if(arr[i].equals("*")) {
                point = (point + dp[i] * 9) % MOD;
                // n-1 번째와 비교
                if(arr[i-1].equals("1")) {
                    point = (point + dp[i-1] * 9) % MOD;
                } else if(arr[i-1].equals("2")) {
                    point = (point + dp[i-1] * 6) % MOD;
                } else if(arr[i-1].equals("*")) {
                    point = (point + dp[i-1] * 15) % MOD;
                }
            } else {
                if(!arr[i].equals("0")) point = (point + dp[i]) % MOD;
                // n-1 번째와 비교
                if(arr[i-1].equals("1")) {
                    point = (point +dp[i-1]) % MOD;
                } else if(arr[i-1].equals("2")) {
                    if(Integer.parseInt(arr[i]) >=0 && Integer.parseInt(arr[i]) < 7) point= (point + dp[i-1]) % MOD;
                } else if(arr[i-1].equals("*")) {
                    int a = Integer.parseInt(arr[i]);
                    if(a<=6) point = (point+dp[i-1] * 2) % MOD;
                    else point = (point+dp[i-1]) % MOD;
                }
            }
            dp[i+1] = point;
        }
//        System.out.println(Arrays.toString(dp));
        return (int) dp[dp.length-1];
    }

    public static void main(String[] args) {
        int a = numDecodings("**");
        System.out.println(a);
    }
}
