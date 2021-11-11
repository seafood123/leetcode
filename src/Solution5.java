class Solution5 {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        char[] charArray = s.toCharArray();
        boolean flag = false;
        String result = "";
//        for(int i=0; i<s.length(); i++) {
//            flag = false;
//            for( int j=s.length()-1; j>=i; j-- ) {
////                System.out.println(s.substring(i, j+1));
//                flag = isPalindrome(charArray, i, j);
//                if(flag) {
//                    result = (result.length() < s.substring(i, j+1).length()) ? s.substring(i,j+1) : result;
//                }
//            }
//        }
        String odd = "";
        String even = "";
        for (int i = 0; i < s.length(); i++) {
            odd = isPalindromeOdd(charArray, i, s);
            even = isPalindromeEven(charArray, i, i + 1, s);

//            System.out.println(" middle ==> " + i);
//            System.out.println(odd);
//            System.out.println(" i , i+1 ==> " + i + "," + (i+1));
//            System.out.println(even);

            result = (result.length() < odd.length()) ? (
                    odd.length() < even.length()) ? even : odd :
                    (result.length() < even.length()) ? even : result;
        }

        return result;
    }

    public static boolean isPalindrome(char[] charArray, int start, int end) {
        while (start <= end) {
            if (charArray[start] != charArray[end]) return false;
            start++;
            end--;
        }
        return true;
    }

    public static String isPalindromeOdd(char[] charArray, int middle, String s) {
        int start = middle - 1;
        int end = middle + 1;
        if(start < 0 || end >= charArray.length) return s.charAt(middle)+"";
        while (start >= 0 && end < charArray.length) {
            if (charArray[start] != charArray[end]) return s.substring(start+1, end);
            start--;
            end++;
        }
        return s.substring(start+1, (end >= s.length()) ? s.length() : end);
    }

    public static String isPalindromeEven(char[] charArray, int start, int end, String s) {
        if(start < 0 || end >= s.length()) return "";
        if (charArray[start] != charArray[end]) return "";
        while (start >= 0 && end < charArray.length) {
            if (charArray[start] != charArray[end]) return s.substring(start+1, end);
            start--;
            end++;
        }
        return s.substring(start+1, (end >= s.length()) ? s.length() : end );
    }

    public static void main(String[] args) {
        String result = longestPalindrome("abb");
        System.out.println(result);
    }
}