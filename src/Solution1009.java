class Solution1009 {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
        int copy = n;
        int bit = 1;
        while(n > 0) {
            copy = copy ^ bit;
            bit = bit << 1;
            n = n >> 1;
        }
        return copy;
    }

    public static void main(String[] args) {
        Solution1009 s = new Solution1009();
        s.bitwiseComplement(7);
    }
}