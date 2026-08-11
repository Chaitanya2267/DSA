import java.util.Arrays;

class minEatingSpeed {
    private long calculateTotalHours(int[] piles, int speed) {
        long totalHours = 0;

        for (int bananas : piles) {
            totalHours += (bananas + (long) speed - 1) / speed;
        }

        return totalHours;
    }

    public int minspeed(int[] piles, int h) {
        int maxPile = Arrays.stream(piles).max().getAsInt();

        int low = 1;
        int high = maxPile;
        int answer = maxPile;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long totalHours = calculateTotalHours(piles, mid);

            if (totalHours <= h) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }
}
