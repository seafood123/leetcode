class Solution476 {
    public int findComplement(int num) {
        int mask = 1;
        int copy = num;
        while(copy > 0) {
            System.out.println(num);
            num = num ^ mask;
            mask <<= 1;
            copy >>= 1;
        }
        return num;

        // 원시적인 방법
//        if(num == 1) return 0;
//        if(num == 0) return 1;
//        long n = 1;
//        while(n <= num) {
//            System.out.println(n);
//            n *= 2;
//        }
//        return (int)(num ^ (n-1));
    }

    public static void main(String[] args) {
        Solution476 s = new Solution476();
        System.out.println(s.findComplement(5));
    }
}