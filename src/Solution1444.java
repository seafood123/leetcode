class Solution1444 {
    public int maxPower(String s) {
        char[] arr = s.toCharArray();
        int[] memo = new int[arr.length];
        memo[arr.length-1] = 1;
        int max = 1;
        for(int i=arr.length-2; i>=0; i--) {
            if(arr[i] == arr[i+1]) {
                memo[i] = memo[i+1] + 1;
            }else {
                memo[i] = 1;
            }
            max = memo[i] > max ? memo[i] : max;
        }
        return max;
    }
}