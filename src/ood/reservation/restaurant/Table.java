package ood.reservation.restaurant;

public class Table {

    private int id;
    private int size;
    private TimeSlots timeSlots;

    public Table(int id, int size, TimeSlots timeSlots) {
        this.id = id;
        this.size = size;
        this.timeSlots = timeSlots;
    }

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public TimeSlots getTimeSlots() {
        return timeSlots;
    }

    public boolean isAvailableForReservation(long start, long end, int size) {
        return size <= getSize() && timeSlots.isFree(start, end);
    }

    public void reserveTable(long start, long end, int size) {

        if (!isAvailableForReservation(start, end, size)) {
            throw new RuntimeException("Table " + id + " cannot be reserved");
        }

        timeSlots.tryReserve(start, end);
    }

    public void clear() {
        timeSlots.setToDefault();
    }

}
