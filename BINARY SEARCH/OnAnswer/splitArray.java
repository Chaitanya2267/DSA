class splitArray {
    public int BS(int[] nums, int maxSubarrays) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int requiredSubarrays = countRequiredSubarrays(nums, mid);
            if (requiredSubarrays > maxSubarrays) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
    private int countRequiredSubarrays(int[] nums, int maximumAllowedSum) {
        int subarrayCount = 1;
        long currentSubarraySum = 0;
        for (int number : nums) {
            if (currentSubarraySum + number <= maximumAllowedSum) currentSubarraySum += number;
            else {
                subarrayCount++;
                currentSubarraySum = number;
            }
        }
        return subarrayCount;
    }
}
