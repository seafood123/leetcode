class Solution67 {
    public String addBinary(String a, String b) {
        int aLen = a.length()-1;
        int bLen = b.length()-1;

        int carry = 0;
        int aValue = 0;
        int bValue = 0;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        while(aLen >= 0 || bLen >= 0) {
            aValue = aLen < 0 ? 0 : a.charAt(aLen) - '0';
            bValue = bLen < 0 ? 0 : b.charAt(bLen) - '0';

            sum = aValue + bValue + carry;
            carry = 0;
            if(sum >= 2) {
                sum %= 2;
                carry = 1;
            }
            sb.append(sum);
            aLen--;
            bLen--;
        }
        if(carry == 1) sb.append("1");
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution67 s = new Solution67();
        String str = s.addBinary("111", "100");
        System.out.println(str);
    }
}