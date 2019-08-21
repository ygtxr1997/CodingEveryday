class Solution {
    public double[] sampleStats(int[] count) {
        int min = -1, max = count.length;
        while (++min < count.length && count[min] == 0);
        while (--max >= 0 && count[max] == 0);

        double sum = 0;
        int numCount = 0;
        int mode = 0;
        for(int i = min; i <= max; i++){
            sum += i * count[i];
            numCount += count[i];
            if(count[i] > count[mode])
                mode = i;
        }

        if(numCount == 1){
            return new double[]{min, max, sum / numCount, sum, mode};
        }
//        If total is odd:
//        m1 = (total + 1) / 2 = total / 2 + 1 = m2
//        They both refer to same single median item.
//        if total is even:
//        m1 = (total + 1) / 2 = total / 2
//        m1 + 1 = m2
        double median = 0;
        int m1 = (numCount + 1) / 2, m2 = numCount / 2 + 1;
        for (int i = min, cnt = 0;  i <= max; ++i) {
            if (cnt < m1 && cnt + count[i] >= m1)
                median += i / 2.0d;
            if (cnt < m2 && cnt + count[i] >= m2)
                median += i / 2.0d;
            cnt += count[i];
        }

        return new double[]{min, max, sum / numCount, median, mode};
    }
}