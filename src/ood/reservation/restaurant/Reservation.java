package ood.reservation.restaurant;

public class Reservation {

    private int customerId;
    private long start;
    private long end;
    private int size;
    private int tableId;

    public Reservation(int customerId, long start, long end, int size, int tableId) {
        this.customerId = customerId;
        this.start = start;
        this.end = end;
        this.size = size;
        this.tableId = tableId;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public int getSize() {
        return size;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getTableId() {
        return tableId;
    }
}
