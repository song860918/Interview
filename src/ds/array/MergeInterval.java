package ds.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }
        List<Interval> result = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        int i = 0;
        while (i < intervals.size() - 1) {
            if (isOverlapped(intervals.get(i), intervals.get(i + 1))) {
                intervals.get(i + 1).start = Math.min(intervals.get(i).start, intervals.get(i + 1).start);
                intervals.get(i + 1).end = Math.max(intervals.get(i).end, intervals.get(i + 1).end);
            } else {
                result.add(intervals.get(i));
            }
            i++;
        }
        result.add(intervals.get(i));

        return result;
    }

    private boolean isOverlapped(Interval a, Interval b) {
        return a.start <= b.end && b.start <= a.end;
    }
}