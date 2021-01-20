import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution537 {
	public static void main(String[] args) {
		System.out.println(complexNumberMultiply("1+-1i", "1+-1i"));
	}
    public static String complexNumberMultiply(String a, String b) {
        List<String> list = new ArrayList<>();
        String[] first = a.split("\\+");
        String[] second = b.split("\\+");
        list.add(Integer.parseInt(first[0]) * Integer.parseInt(second[0]) + "");
        list.add((-1*Integer.parseInt(first[1].split("i")[0]) * Integer.parseInt(second[1].split("i")[0])) + "");
        list.add(Integer.parseInt(first[0]) * Integer.parseInt(second[1].split("i")[0])+"");
        list.add(Integer.parseInt(first[1].split("i")[0]) * Integer.parseInt(second[0])+"");
        
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.parseInt(list.get(0))+Integer.parseInt(list.get(1)));
        sb.append("+");
        sb.append(Integer.parseInt(list.get(2)) + Integer.parseInt(list.get(3))+"i");
        
        return sb.toString();
    }
}