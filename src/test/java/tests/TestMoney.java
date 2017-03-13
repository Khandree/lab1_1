package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Locale;

import org.junit.Test;

import junit.framework.Assert;
import pl.com.bottega.ecommerce.sales.domain.offer.Money;

public class TestMoney {

	@Test
	public void testIfAreSameDefaultModifiers() {
		Money money_1 = new Money(1000);
		Money money_2 = new Money(1000);
		assertEquals(money_1, money_2);
	}
	@Test
	public void testIfAreSameEqualDefaultModifiers() {
		Money money_1 = new Money(1000);
		Money money_2 = new Money(1000);
		assertTrue(money_1.equals(money_2));
	}
	@Test
	public void testCompareDefaultModifiers() {
		Money money_1 = new Money(1000);
		Money money_2 = new Money(1000);
		assertEquals(0, money_1.compareTo(money_2));
		money_1 = new Money(1000);
		money_2 = new Money(2000);
		assertEquals(1, money_1.compareTo(money_2));
		money_1 = new Money(2000);
		money_2 = new Money(1000);
		assertEquals(-1, money_1.compareTo(money_2));
		money_1 = new Money(0);
		money_2 = new Money(4);
		int cmp = money_1.compareTo(money_2);
		System.out.println(cmp);
		assertEquals(1, cmp);
	}

	@Test
	public void testCompareCurrencyAmount() {
		Money money_1 = new Money(1000, Currency.getInstance("EUR"));
		Money money_2 = new Money(1000, Currency.getInstance("EUR"));
		assertEquals(0, money_1.compareTo(money_2));
		money_1 = new Money(1000, Currency.getInstance(Locale.ITALY));
		money_2 = new Money(2000, Currency.getInstance("EUR"));
		assertEquals(1, money_1.compareTo(money_2));
		money_1 = new Money(2000, Currency.getInstance("EUR"));
		money_2 = new Money(1000, Currency.getInstance(Locale.ITALY));
		assertEquals(-1, money_1.compareTo(money_2));
	}

	@Test
	public void testCompareModeAmount() {
		Money money_1 = new Money(1000, RoundingMode.UP);
		Money money_2 = new Money(1000, RoundingMode.UP);
		assertEquals(0, money_1.compareTo(money_2));
		money_1 = new Money(1000, RoundingMode.UP);
		money_2 = new Money(2000, RoundingMode.DOWN);
		assertEquals(1, money_1.compareTo(money_2));
		money_1 = new Money(2000, RoundingMode.DOWN);
		money_2 = new Money(1000, RoundingMode.UP);
		assertEquals(-1, money_1.compareTo(money_2));
		money_1 = new Money(1000, RoundingMode.DOWN);
		money_2 = new Money(2000, RoundingMode.UP);
		assertEquals(1, money_1.compareTo(money_2));
		money_1 = new Money(2000, RoundingMode.UP);
		money_2 = new Money(1000, RoundingMode.DOWN);
		assertEquals(-1, money_1.compareTo(money_2));
	}

	@Test
	public void testIfAreSameCurrency() {
		Money money_1 = new Money(1000, Currency.getInstance("EUR"));
		Money money_2 = new Money(1000, Currency.getInstance("EUR"));
		assertEquals(money_1, money_2);
		money_1 = new Money(1000, Currency.getInstance("EUR"));
		money_2 = new Money(1000, Currency.getInstance("PLN"));
		assertNotEquals(money_1, money_2);
	}

	@Test
	public void testIfAreSameRounding() {
		Money money_1 = new Money(1000, RoundingMode.UP);
		Money money_2 = new Money(1000, RoundingMode.UP);
		assertEquals(money_1, money_2);
		money_1 = new Money(1000, RoundingMode.UP);
		money_2 = new Money(1000, RoundingMode.DOWN);
		assertNotEquals(money_1, money_2);
	}

	@Test
	public void testMoneyOperations() {
		Money money_1 = new Money(1000);
		Money money_2 = new Money(1000);
		assertEquals(BigDecimal.valueOf(0), money_1.subtract(money_2).getAmount());
		assertEquals(BigDecimal.valueOf(2000), money_1.add(money_2).getAmount());
	}

	@Test
	public void testMoneyAdditionDiffrentCurrency() {
		Money money_1 = new Money(1000, Currency.getInstance("EUR"));
		Money money_2 = new Money(1000, Currency.getInstance("USD"));
		assertNull(money_1.add(money_2));
	}
	
	@Test
	public void testMoneyToString() {
		Money money_1 = new Money(1000, Currency.getInstance("USD"));
		String moneyStr = money_1.toString();
		assertTrue(moneyStr.equals("1000 $"));
	}
}
