// Feeling like an English reading comprehension problem ———— czhangaegean（评论区的某哥们）

class Solution {
    public boolean validUtf8(int[] data) {
        int pos = 0;
        while (pos < data.length){
            int tmp = data[pos];
            //对多字节的UTF-8编码进行处理
            if((tmp & 0x7f) != 0){
                int count = 0;
                //计算该多字节编码所含字节的个数
                while ((tmp & 1 << (7 - count)) != 0){
                    count++;
                    if(count > 4)
                        return false;
                }
                //对异常情况进行处理
                if(count == 1|| pos + count > data.length|| (tmp & 1<<(7 - count)) != 0)
                    return false;
                //依次判别多字节编码除首字节以外的各字节是否合法
                while (--count > 0){
                    if((data[++pos] & 0xc0) != 128)
                        return false;
                }
            }
            pos++;
        }
        
        return true;
    }
}