class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        if(trips.length == 0)
            return true;
        if(capacity <= 0)
            return false;

        int maxEnd = 0;
        for(int i = 0; i < trips.length; i++){
            maxEnd = trips[i][2] > maxEnd? trips[i][2]: maxEnd;
        }
        int[] journey = new int[maxEnd + 1];
        for(int i = 0; i < trips.length; i++){
            journey[trips[i][1]] += trips[i][0];
            journey[trips[i][2]] -= trips[i][0];
        }
        int seats = 0;
        for(int i = 0; i < journey.length; i++){
            seats += journey[i];
            if(seats > capacity)
                return false;
        }
        
        return true;
    }
}