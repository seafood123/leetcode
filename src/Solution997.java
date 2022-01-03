class Solution997 {
    public int findJudge(int n, int[][] trust) {
        if(n==1) return 1;
        int[] count = new int[n+1];
        for(int[] tr : trust) {
            count[tr[0]]--;
            count[tr[1]]++;
        }
        for(int i=0; i< count.length;i++) {
            if(count[i] == n-1) return i;
        }
        return -1;
    }
}