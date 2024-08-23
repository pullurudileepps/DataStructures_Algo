
import Arrays.MergeInterval;

import java.util.ArrayList;

public class practice {
    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(7, 8));

        Interval newInterval = new Interval(5, 6);
        ArrayList<Interval> intervals1 = MergeInterval(intervals, newInterval);
        System.out.println(intervals1);
        //[1,3],[6,9]
        //[2,5]
    }

    public static ArrayList<Interval> MergeInterval(ArrayList<Interval> intervals, Interval newInterval) {
        int i = 0;
        int start = newInterval.start;
        int end = newInterval.end;
        int startIndex = -1;
        int endIndex = -1;
        for (Interval in : intervals) {
            if (start >= in.start && start <= in.end)
                startIndex = i;
            if (end >= in.start && end <= in.end)
                endIndex = i;
            i++;
        }
        if(startIndex == -1 && endIndex == -1) {
            for (i = 0; i < intervals.size(); i++) {
                if (start > intervals.get(i).end) {
                    startIndex = i + 1;
                }
            }
            for (i = intervals.size() - 1; i >= 0; i--) {
                if (end < intervals.get(i).start) {
                    endIndex = i - 1;
                }
            }

            intervals.add(startIndex, newInterval);
            return intervals;

        }
        if (startIndex == -1) {
            for (i = intervals.size() - 1; i >= 0; i--) {
                if (start <= intervals.get(i).start) {
                    startIndex = i;
                }
            }
        }
        if (endIndex == -1) {
            for (i = 0; i < intervals.size(); i++) {
                if (end >= intervals.get(i).end) {
                    endIndex = i;
                }
            }
        }

        start = Math.min(intervals.get(startIndex).start, start);
        end = Math.max(intervals.get(endIndex).end, end);
        intervals.get(startIndex).start = start;
        intervals.get(startIndex).end = end;
        return intervals;
    }
}
