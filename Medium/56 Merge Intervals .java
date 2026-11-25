import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort intervals by their starting values
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        // Add the first interval
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {

            int[] current = intervals[i];

            // Get the last interval added to the result
            int[] last = result.get(result.size() - 1);

            // Check if intervals overlap
            if (current[0] <= last[1]) {

                last[1] = Math.max(last[1], current[1]);

            } else {

                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}