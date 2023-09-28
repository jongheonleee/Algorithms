class Solution {
    final int CACHE_MISS = 5;
    final int CACHE_HIT = 1;
    
    public int solution(int cacheSize, String[] cities) {
        int ans = 0;
        if (cacheSize == 0) {
            ans = cities.length * CACHE_MISS;
            return ans;
        }

        String[] cache = new String[cacheSize];

        for (String city : cities) {
            int pos = -1;

            for (int i=0; i<cache.length; i++) {
                if ((cache[i] != null && !cache[i].isBlank())&& city.compareToIgnoreCase(cache[i]) == 0) {
                    pos = i;
                    break;
                }
            }

            if (pos == -1) {
                ans += CACHE_MISS;
                for (int i=cacheSize-2; i>=0; i--) {
                    cache[i+1] = cache[i];
                }
            } else {
                ans += CACHE_HIT;

                for (int i=pos-1; i>=0; i--) {
                    cache[i+1] = cache[i];
                }
            }
            cache[0] = city;
        }


        return ans;
    }
}