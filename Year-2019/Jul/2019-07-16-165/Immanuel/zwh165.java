class Solution {
    public int compareVersion(String version1, String version2) {
        String[] fields1 = version1.split("\\.");
        String[] fields2 = version2.split("\\.");

        int index = 0;
        while (index < fields1.length && index < fields2.length){
            int field1 = Integer.valueOf(fields1[index]);
            int field2 = Integer.valueOf(fields2[index]);
            if(field1 != field2)
                return field1 > field2? 1: -1;
            index++;
        }

        if(fields1.length > fields2.length){
            while (index < fields1.length){
                if(Integer.valueOf(fields1[index++]) != 0)
                    return 1;
            }
            return 0;
        }
        else if(fields2.length > fields1.length){
            while (index < fields2.length){
                if(Integer.valueOf(fields2[index++]) != 0)
                    return -1;
            }
            return 0;
        }
        else return 0;
    }
}