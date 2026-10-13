// 1207. Unique Number of Occurrences

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>();
        for(int freq  : map.values()){
            if(set.contains(freq)) {
                return false;
            }
            set.add(freq);
        }
        return true;
    }
}

// ----------------------------------------------------

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] ca = new int[2001];
        for(int i : arr) { ca[i + 1000]++; }
        Arrays.sort(ca);
        for(int i = 0; i < 2000; i++) {
            if(ca[i] != 0 && ca[i] == ca[i + 1]) { return false; }
        }
        return true;
    }
}
