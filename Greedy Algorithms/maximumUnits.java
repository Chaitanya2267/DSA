// 1710. Maximum Units on a Truck

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int totalUnits = 0;
        for(int i = 0; i < boxTypes.length; i++) {
            int numberOfBoxes = boxTypes[i][0];
            int unitsPerBox = boxTypes[i][1];
            int boxesToTake = Math.min(numberOfBoxes, truckSize);
            totalUnits += boxesToTake * unitsPerBox;
            truckSize -= boxesToTake;
            if(truckSize == 0) { break; }
        }
        return totalUnits;
    }
}
