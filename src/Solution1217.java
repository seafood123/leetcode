import java.util.HashMap;
import java.util.Map;

class Solution1217 {
    public int minCostToMoveChips(int[] position) {
        if(position == null || position.length == 0) return 0;
        int odd = 0;
        int even = 0;
        for(int i=0; i<position.length; i++) {
            if(position[i] % 2 == 1) odd ++;
            else even++;
        }

        return odd > even ? even : odd;
    }
}