import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        // ваш код
        int length1 = t1.getTimeTo() - t1.getTimeFrom();
        int length2 = t2.getTimeTo() - t2.getTimeFrom();
        if (length1 < length2) {
            return -1;
        } else if (length1 > length2) {
            return 1;
        } else {
            return 0;
        }
    }
}