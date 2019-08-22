class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;

        int rowSize = s1.length() + 1;
        int colSize = s2.length() + 1;
        boolean[][] map = new boolean[rowSize][colSize];
        for(boolean[] tmp: map){
            Arrays.fill(tmp, false);
        }

        //也可以不用BFS，将map的两条边处理完之后，直接遍历map也可以，而且看起来更直观
        map[0][0] = true;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0, 0});
        for(int i = 0; i < s3.length(); i++){
            int size = que.size();
            while (size-- > 0){
                int[] tmp = que.poll();
                if(!map[tmp[0]][tmp[1]])
                    continue;
                if(tmp[0] + 1 < rowSize){
                    map[tmp[0] + 1][tmp[1]] = map[tmp[0]][tmp[1]] && s3.charAt(i) == s1.charAt(tmp[0]);
                    que.offer(new int[]{tmp[0] + 1, tmp[1]});
                }
                if(tmp[1] + 1 < colSize && !map[tmp[0]][tmp[1] + 1]){
                    map[tmp[0]][tmp[1] + 1] = map[tmp[0]][tmp[1]] && s3.charAt(i) == s2.charAt(tmp[1]);
                    que.offer(new int[]{tmp[0], tmp[1] + 1});
                }
            }
        }

        return map[s1.length()][s2.length()];
    }
}