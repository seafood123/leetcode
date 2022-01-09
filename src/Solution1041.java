class Solution1041 {
    public boolean isRobotBounded(String instructions) {
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int i = 0;
        int x = 0;
        int y = 0;
        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                x = x + dir[i][0];
                y = y + dir[i][1];
            } else if (c == 'R') {
                i = (i + 1) % 4;
            } else {
                i = (i + 3) % 4;
            }
        }
        return (x == 0 && y == 0) || (i != 0);
    }
}