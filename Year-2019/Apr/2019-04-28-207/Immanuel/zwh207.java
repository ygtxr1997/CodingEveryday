public class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         int[][] graph = new int[numCourses][numCourses];
//         int[] inDegree = new int[numCourses];

//         for(int i = 0; i < prerequisites.length; i++){
//             int pre = prerequisites[i][1];
//             int post = prerequisites[i][0];
//             graph[pre][post] = 1;
//             inDegree[post]++;
//         }
//         Queue<Integer> queue = new LinkedList<>();
//         for(int i = 0; i < numCourses; i++){
//             if(inDegree[i] == 0)
//                 queue.offer(i);
//         }

//         int count = 0;
//         while (!queue.isEmpty()){
//             int pre = queue.poll();
//             count++;
//             for(int i = 0; i < numCourses; i++){
//                 if(graph[pre][i] == 1&& --inDegree[i] == 0){
//                     queue.offer(i);
//                 }
//             }
//         }


//         return count == numCourses;
//     }
    
     public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        int count = 0;
        while (!queue.isEmpty()){
            int pre = queue.poll();
            count++;
            for(int i = 0; i < graph[pre].size(); i++){
                int post = (int)graph[pre].get(i);
                if(--inDegree[post] == 0){
                    queue.offer(post);
                }
            }
        }

        return count == numCourses;
    }
}