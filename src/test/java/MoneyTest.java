import model.Bank;
import model.Expression;
import model.Money;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by robertmcbryde on 11/04/15.
 */
public class MoneyTest {

    @Test
    public void testMultiplication() throws Exception {
        Money five = Money.pound(5);
        assertEquals(Money.pound(10), five.times(2));
        assertEquals(Money.pound(15), five.times(3));
    }

    @Test
    public void testEquality() throws Exception {
        assertTrue(Money.pound(2).equals(Money.pound(2)));
        assertFalse(Money.pound(2).equals(Money.pound(3)));
        assertFalse(Money.pound(2).equals(Money.franc(2)));
    }

    @Test
    public void testFrancMulitplication() throws Exception {
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    public void testCurrency() throws Exception {
        assertEquals("GBP", Money.pound(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void testSimpleeAddition() throws Exception {
        Money five = Money.pound(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "GBP");
        assertEquals(Money.pound(10), reduced);
    }
}


