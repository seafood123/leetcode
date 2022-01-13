import java.util.Arrays;
import java.util.Comparator;
class Solution452 {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        int shoot = 0;

        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        int end = points[0][1];

        for(int i=1; i<points.length; i++) {
            if(end < points[i][0]) {
                shoot++;
                end = points[i][1];
            }
        }

        return shoot+1;
    }

    public static void main(String[] args) {
        Solution452 s = new Solution452();
        int a = s.findMinArrowShots(new int[][]
                {{7,15},{6,14},{8,12},{3,4},{4,13},{6,14},{9,11},{6,12},{4,13}});
        System.out.println(a);
    }
}