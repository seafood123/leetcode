// you can also use imports, for example:
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Main{
    public static String answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int items = Integer.parseInt(st.nextToken());
        int question = Integer.parseInt(st.nextToken());
        int[] parent = new int[items+1];

        int p, c;

        for(int i=0;i<items-1;i++){
            st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            parent[c] = p;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<question;i++){
            answer = "";
            st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            isParent(parent, c, p);
            if(answer.equals("")) sb.append("no");
            else sb.append(answer);

            if(i != question-1) sb.append("\n");

        }

        System.out.println(sb.toString());

    }

    public static void isParent(int[] parent, int c, int p){

        if(p==c){
            answer="yes";
            return;
        }

        if(parent[c] == p){
            answer = "yes";
            return;
        }

        if(parent[c] == 0) return;
        LocalDateTime.now();
        isParent(parent,parent[c],p);

    }



}
