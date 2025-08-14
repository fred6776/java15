import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    @Test
    void shouldCompareTo() {
        Ticket t1 = new Ticket("SPB", "SVO", 10000, 1000, 1400);
        Ticket t2 = new Ticket("SPB", "SVO", 12000, 1100, 1500);

        int expected = -1;
        int actual = t1.compareTo(t2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {
        AviaSouls manager = new AviaSouls();
        manager.add(new Ticket("SPB", "SVO", 10000, 1000, 1400));
        manager.add(new Ticket("SPB", "SVO", 12000, 1100, 1500));
        manager.add(new Ticket("SPB", "SVO", 8000, 1100, 1500));
        manager.add(new Ticket("SPB", "SVO", 15000, 1000, 1400));
        Ticket[] result = manager.findAll();
        int expected = 4;
        int actual = result.length;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSearchSort() {
        AviaSouls manager = new AviaSouls();
        manager.add(new Ticket("SPB", "SVO", 10000, 1000, 1400));
        manager.add(new Ticket("SPB", "SVO", 12000, 1100, 1500));
        manager.add(new Ticket("SPB", "SVO", 8000, 1100, 1500));
        manager.add(new Ticket("SPB", "SVO", 15000, 1000, 1400));
        Ticket[] result = manager.search("SPB", "SVO");
        int expected = 10000;
        int actual = result[1].getPrice();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCompare() {
        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket t1 = new Ticket("SPB", "SVO", 10000, 1000, 1100);
        Ticket t2 = new Ticket("SPB", "SVO", 12000, 1000, 1200);

        int expected = -1;
        int actual = comparator.compare(t1, t2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSearchAndSortBy() {
        AviaSouls manager = new AviaSouls();
        manager.add(new Ticket("SPB", "SVO", 12000, 1100, 1500));//400
        manager.add(new Ticket("SPB", "SVO", 10000, 1000, 1600));//600
        manager.add(new Ticket("SPB", "SVO", 11000, 1000, 1300));//300
        manager.add(new Ticket("SPB", "SVO", 12000, 1000, 1400));//400

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] result = manager.searchAndSortBy("SPB", "SVO", comparator);

        int expected = 400;
        int actual = result[1].getTimeTo() - result[1].getTimeFrom();
        Assertions.assertEquals(expected, actual);
    }

}