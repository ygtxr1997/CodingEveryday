public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List[] graph = new List[numCourses];
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList();
        }

        for(int i = 0; i < prerequisites.length; i++){
            int pre = prerequisites[i][1];
            int post = prerequisites[i][0];
            graph[pre].add(post);
            inDegree[post]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0)
                queue.offer(i);
        }

        int[] outPut = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()){
            int pre = queue.poll();
            outPut[count] = pre;
            count++;
            for(int i = 0; i < graph[pre].size(); i++){
                int post = (int)graph[pre].get(i);
                if(--inDegree[post] == 0){
                    queue.offer(post);
                }
            }
        }

        return count == numCourses? outPut: new int[0];
    }
}