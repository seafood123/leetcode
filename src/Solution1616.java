class Solution1616 {
	public static void main(String[] args) {
		System.out.println(checkPalindromeFormation("abdef", "fecab"));
	}

	public static boolean[][] aPelin;
	public static boolean[][] bPelin;

	public static boolean checkPalindromeFormation(String a, String b) {

		if (isPelin(a, 0, a.length() - 1) || isPelin(b, 0, b.length() - 1))
			return true;

		return check(a, b) || check(b, a);
	}

	public static boolean check(String a, String b) {
		int start = 0;
		int end = b.length() - 1;

		while (start <= end) {
			if (a.charAt(start) != b.charAt(end)) {
				if (isPelin(a, start, end) || isPelin(b, start, end)) {
					return true;
				} else {
					return false;
				}
			}
			start++;
			end--;
		}
		return true;
	}

	public static boolean isPelin(String str, int start, int end) {
		int s = start;
		int e = end;

		while (s <= e) {
			if (str.charAt(s) == str.charAt(e)) {
				s++;
				e--;
			} else {
				return false;
			}
		}

		return true;

	}

}