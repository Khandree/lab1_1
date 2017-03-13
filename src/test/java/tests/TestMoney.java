package tests;



import static org.junit.Assert.*;

import java.math.RoundingMode;
import java.util.Currency;

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
	public void testIfAreSameCurrency() {
		Money money_1 = new Money(1000, Currency.getInstance("EUR"));
		Money money_2 = new Money(1000, Currency.getInstance("EUR"));
		assertEquals(money_1, money_2);
	}
	
	@Test
	public void testIfAreNotSameCurrency() {
		Money money_1 = new Money(1000, Currency.getInstance("EUR"));
		Money money_2 = new Money(1000, Currency.getInstance("PLN"));
		assertNotEquals(money_1, money_2);
	}
	
	@Test
	public void testIfAreSameRounding() {
		Money money_1 = new Money(1000, RoundingMode.UP);
		Money money_2 = new Money(1000, RoundingMode.UP);
		assertEquals(money_1, money_2);
	}
	
	@Test
	public void testIfAreNotSameRounding() {
		Money money_1 = new Money(1000, RoundingMode.UP);
		Money money_2 = new Money(1000, RoundingMode.DOWN);
		assertNotEquals(money_1, money_2);
	}
	
	@Test
	public void testMoneySubtraction() {
		Money money_1 = new Money(1000);
		Money money_2 = new Money(1000);
		Money money_3 = new Money(0);
		assertEquals(money_1.subtract(money_2), money_3);
	}
}

