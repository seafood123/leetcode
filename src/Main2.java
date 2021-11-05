import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    public static class Dest{
        public String dest;
        public int cost;
        public Dest(String dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }
    public static class Node implements Comparable<Node>{

        public String start;
        public String dest;
        public Set<String> destSet;
        public int cost;

        public Node(String start, String dest, Set<String> destSet,int cost){
            this.start = start;
            this.dest = dest;
            this.destSet = destSet;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(br.readLine());
        StringTokenizer st;

        String p1 = "";
        String p2 = "";
        int cost = 0;
        HashMap<String, List<Dest>> map = new HashMap<>();
        List<Dest> d1;
        List<Dest> d2;
        Set<String> s1;
        PriorityQueue<Node> queue = new PriorityQueue<>();

        for(int i=0;i<line;i++){

            st = new StringTokenizer(br.readLine());

            p1 = st.nextToken();
            p2 = st.nextToken();
            cost = Integer.parseInt(st.nextToken());
            d1 = map.get(p1);
            if(d1 == null) d1 = new ArrayList<>();
            d1.add(new Dest(p2, cost));

            map.put(p1, d1);

            d2 = map.get(p2);
            if(d2 == null) d2 = new ArrayList<>();
            d2.add(new Dest(p1, cost));

            map.put(p2, d2);

            s1 = new HashSet<>();
            s1.add(p1);
            s1.add(p2);

            queue.add(new Node(p1,p2,s1,cost));
            queue.add(new Node(p2,p1,s1,cost));

        }
        Node n;
        while(!queue.isEmpty()){
            n = queue.poll();

            if(n.destSet.size()==map.size()){
                System.out.println(n.cost);
                return;
            }

            List<Dest> list = map.get(n.dest);
            for(int i=0;i<list.size();i++){
                Dest dest = list.get(i);
                if(n.destSet.contains(dest.dest)) continue;
                Set<String> set = new HashSet<>();
                for(String s : n.destSet){
                    set.add(s);
                }
                set.add(dest.dest);
                queue.add(new Node(n.dest, dest.dest, set, n.cost+dest.cost));
            }


        }


    }
}
