package tests;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import pl.com.bottega.ecommerce.sales.domain.offer.Discount;
import pl.com.bottega.ecommerce.sales.domain.offer.DiscountType;
import pl.com.bottega.ecommerce.sales.domain.offer.Money;

public class TestDiscount {

	@Test
	public void testDiscountValue(){
		Discount discount = new Discount(new Money(10), DiscountType.VALUE);
		Assert.assertEquals(discount.price(new Money(100)).getAmount(), BigDecimal.valueOf(90));
		Discount discount_2 = new Discount(new Money(10), DiscountType.PROCENTAGE);
		Assert.assertEquals(discount.price(new Money(100)).getAmount(), BigDecimal.valueOf(90));
	}
	
}
