import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main17071 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(find(n, k));


    }

    public static int find(int n, int k) {
        boolean[][] visited = new boolean[500001][2];
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        if(k == n) {
            return time;
        }
        queue.add(new int[]{n, 0});
        int back, front, jump;
        int queueSize = 0;
        int nowN;
        int nowTime;
        int[] now;

        while(true) {
            ++time;
            k = time + k;

            if( k > 500000) return -1;
            if(visited[k][time%2]) return time;
            queueSize = queue.size();

            for( int i = 0; i< queueSize; i++) {
                now = queue.poll();
                nowTime = ( now[1] + 1 ) % 2;
                nowN = now[0];

                back = nowN - 1;
                if(back == k) return time;
                if(back >=0 && !visited[back][nowTime]) {
                    visited[back][nowTime] = true;
                    queue.add(new int[]{back, nowTime});
                }

                front = nowN + 1;
                if(front == k) return time;
                if(front <= 500000 && !visited[front][nowTime]) {
                    visited[front][nowTime] = true;
                    queue.add(new int[]{front, nowTime});
                }

                jump = nowN * 2;
                if(jump == k) return time;
                if(jump <= 500000 && !visited[jump][nowTime]) {
                    visited[jump][nowTime] = true;
                    queue.add(new int[]{jump, nowTime});
                }

            }

        }
    }
}