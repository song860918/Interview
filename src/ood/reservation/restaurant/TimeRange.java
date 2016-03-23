package ood.reservation.restaurant;


public class TimeRange {

    private long start;
    private long end;

    public TimeRange(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public long getEnd() {
        return end;
    }

    public long getStart() {
        return start;
    }
}
