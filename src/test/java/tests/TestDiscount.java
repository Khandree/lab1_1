package tests;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import pl.com.bottega.ecommerce.sales.domain.offer.Discount;
import pl.com.bottega.ecommerce.sales.domain.offer.DiscountType;
import pl.com.bottega.ecommerce.sales.domain.offer.Money;

public class TestDiscount {

    @Test
    public void testDiscountValue() {
        Discount discount = new Discount(new Money(10));
        Money afterDiscountValue = new Money(90);
        Assert.assertEquals(discount.price(new Money(100)), afterDiscountValue);
    }

    @Test
    public void testDiscountProcentage() {
        Discount discount = new Discount(10);
        Money afterDiscountValue = discount.price(new Money(100));
        Assert.assertEquals(discount.price(new Money(100)), afterDiscountValue);
    }
}
