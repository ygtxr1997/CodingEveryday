class Solution {
    
    public String simplifyPath(String path) {
        StringBuilder outPut = new StringBuilder();

        String[] tmp = path.split("/");
        Deque<String> que = new LinkedList<>();
        for(String cursor: tmp){
            if(cursor.equals("")|| cursor.equals("."))
                continue;
            if(cursor.equals(".."))
                que.pollLast();
            else
                que.offerLast(cursor);
        }
        while (!que.isEmpty()){
            outPut.append("/").append(que.pollFirst());
        }
        
        if(outPut.length() < 1)
            outPut.append("/");
        return outPut.toString();
    }
    
    
//     public String simplifyPath(String path) {//processing one by one
//         path += "/";
//         StringBuilder outPut = new StringBuilder();
//         outPut.append("/");
//         int flag = 0;
        
//         for(int i = 0; i < path.length(); i++){
//             if(path.charAt(i) == '/'){
//                 if(flag < 2){
//                     if(outPut.charAt(outPut.length() - 1) == '/') ;
//                     else{
//                         outPut.append('/');
//                     }
//                 }
//                 else if(flag > 2){
//                     for(int j = 0;j < flag; j++){
//                         outPut.append('.');
//                     }
//                     outPut.append('/');
//                 }
//                 else{
//                     if(outPut.length() < 3){
//                             outPut.delete(1, outPut.length());
//                     }
//                     else{
//                         for(int j = outPut.length() - 2; j >= 0; j--){
//                             if(outPut.charAt(j) == '/'){
//                                 outPut.delete(j + 1, outPut.length());
//                                 break;   
//                             }
//                         }
//                     }
//                 }
//                 flag = 0;
//             }
//             else if(path.charAt(i) == '.'){
//                 flag++;
//             }
//             else{
//                 if(flag != 0){
//                     for(int j = 0;j < flag; j++){
//                         outPut.append('.');
//                     }
//                 }
//                 outPut.append(path.charAt(i));
//                 flag = 0;
//             }
//         }
        
//         if(outPut.length() > 1&&outPut.charAt(outPut.length() - 1) == '/')
//             outPut.delete(outPut.length() - 1, outPut.length());
        
//         return outPut.toString();
//     }
}