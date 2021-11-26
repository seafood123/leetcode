import java.util.*;

class Solution127 {

    public class Pair<T, U> {
        private T key;
        private U value;

        public Pair(T key, U value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public U getValue() {
            return value;
        }
    }

    private static int LEN;
    private static Map<String, List<String>> adjacentMap;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0 || !wordList.contains(endWord)) return 0;
        adjacentMap = new HashMap<>();
        LEN = beginWord.length();

        wordList.forEach((word) -> {
            String newWord = "";
            for (int i = 0; i < word.length(); i++) {
                newWord = word.substring(0, i) + "*" + word.substring(i + 1, LEN);
                List<String> list = adjacentMap.getOrDefault(newWord, new ArrayList<>());
                list.add(word);
                adjacentMap.put(newWord, list);
            }
        });

        Queue<Pair<String, Integer>> topQueue = new PriorityQueue<>(new Comparator<Pair<String, Integer>>() {
            @Override
            public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
                return o1.getValue().intValue() - o2.getValue().intValue();
            }
        });
        Queue<Pair<String, Integer>> bottomQueue = new PriorityQueue<>(new Comparator<Pair<String, Integer>>() {
            @Override
            public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
                return o1.getValue().intValue() - o2.getValue().intValue();
            }
        });
        topQueue.add(new Pair(beginWord, 1));
        bottomQueue.add(new Pair(endWord, 1));

        Map<String, Integer> visitTop = new HashMap<>();
        visitTop.put(beginWord, 1);
        Map<String, Integer> visitBottom = new HashMap<>();
        visitBottom.put(endWord, 1);

        int ans = 0;
        while (!topQueue.isEmpty() && !bottomQueue.isEmpty()) {
            ans = wordLadder(topQueue, visitTop, visitBottom);
            if(ans > -1) return ans;
            ans = wordLadder(bottomQueue, visitBottom, visitTop);
            if(ans > -1) return ans;
        }

        return 0;
    }

    private int wordLadder(Queue<Pair<String, Integer>> queue, Map<String, Integer> visit, Map<String, Integer> otherVisit) {
        Pair<String, Integer> now = queue.poll();
        String word = now.getKey();
        int level = now.getValue();
        String newWord = "";
        List<String> list;
        for(int i=0; i<LEN; i++) {
            newWord = word.substring(0, i) + "*" + word.substring(i+1, LEN);
            list = adjacentMap.getOrDefault(newWord, new ArrayList<>());
            for(String item : list) {
                if(otherVisit.containsKey(item)) {
                    return level + otherVisit.get(item);
                }

                if(!visit.containsKey(item)) {
                    visit.put(item, level + 1);
                    queue.add(new Pair(item, level+1));
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution127 solution127 = new Solution127();
        int a = solution127.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log"));
        System.out.println(a);
    }
}