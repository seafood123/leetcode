import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Solution1410 {
	public static void main(String[] args) {
		System.out.println(entityParser("&&gt;"));
	}

	public static String entityParser(String text) {
		Map<String, String> hMap = new HashMap<>();
		hMap.put("&quot;", "\"");
		hMap.put("&apos;", "'");
		hMap.put("&amp;", "&");
		hMap.put("&gt;", ">");
		hMap.put("&lt;", "<");
		hMap.put("&frasl;", "/");
		
		Set<Entry<String, String>> set = new HashSet<>(hMap.entrySet());

		for(Entry<String,String> e : set) {
			text = text.replaceAll(e.getKey(),e.getValue());
		}
		
		return text;
		
	}
}