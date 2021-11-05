// you can also use imports, for example:
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Main1{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int index = Integer.parseInt(br.readLine());

        String[] indexs = new String[index];
        for(int i=0;i<index;i++){
            indexs[i] = br.readLine();
        }

        int count = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        String target = "";
        int cnt = 0;
        for(int i=0;i<count;i++){
            cnt = 0;
            target = br.readLine();
            for(int j=0;j<index;j++) {
                if(target.length() > indexs[j].length() || target.length() == indexs[j].length() && !target.equals(indexs[j])) continue;
                if (indexs[j].indexOf(target) != -1) {
                    cnt++;
                }
            }
            if(i==count-1) sb.append(cnt);
            else sb.append(cnt).append("\n");
        }

        System.out.println(sb.toString());



    }

}

