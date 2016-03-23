package ood.reservation.restaurant;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Restaurant {

    private static int id = 0;
    private Map<Integer, Table> tables = new HashMap<>();
    private Map<Integer, Reservation> reservationMap = new HashMap<>();

    public Restaurant(Collection<Table> tables) {

        tables.stream()
                .forEach(table -> this.tables.put(table.getId(), table));
    }

    public Reservation reserveTable(long start, long end, int size) {
        Optional<Table> freeTable = tables.values().stream()
                .filter(table -> table.isAvailableForReservation(start, end, size))
                .findAny();
        if (freeTable.isPresent()) {
            freeTable.get().reserveTable(start, end, size);
            Reservation newReservation = new Reservation(++id, start, end, size, freeTable.get().getId());
            reservationMap.put(newReservation.getCustomerId(), newReservation);
            return newReservation;
        } else {
            return null;
        }
    }

    public Table serveReservation(int customerId) {
        Reservation reservation = reservationMap.get(customerId);

        if(reservation == null) {
            return null;
        }

        Table reservedTable = tables.get(reservation.getTableId());

        if (System.currentTimeMillis() > reservation.getStart() && System.currentTimeMillis() < reservation.getEnd()) {
            return reservedTable;
        } else {
            return null;
        }
    }

}
