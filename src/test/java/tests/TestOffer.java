package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import org.junit.Test;

import pl.com.bottega.ecommerce.sales.domain.offer.Discount;
import pl.com.bottega.ecommerce.sales.domain.offer.Money;
import pl.com.bottega.ecommerce.sales.domain.offer.OfferItem;
import pl.com.bottega.ecommerce.sales.domain.offer.Product;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 187472
 */
public class TestOffer {

	@Test
	public void testProductAreSame() {
		Date data = new Date();
		Money amount = new Money(1);
		Product productA = new Product("123", amount, "ZUPA", data, "TYPE_1");
		Product productB = new Product("123", amount, "ZUPA", data, "TYPE_1");
		assertTrue(productA.equals(productB));
	}

	@Test
	public void testOfferDiscount() {
		Date data = new Date();
		Money price = new Money(1);
		Money template = new Money(1);
		Discount discount = new Discount(10);
		Discount discountTemplate = new Discount(10);
		Product product = new Product("123", price, "ZUPA", data, "TYPE_1");
		OfferItem itemA = new OfferItem(product, 1, discount);
		Money afterDiscount = itemA.getTotalCost();
		assertTrue(afterDiscount.equals(discountTemplate.price(template)));
	}
	@Test
	public void testOfferNoDiscount() {
		Date data = new Date();
		Money price = new Money(1);
		Money template = new Money(1);
		Discount discount = new Discount(null);
		Discount discountTemplate = new Discount(0);
		Product product = new Product("123", price, "ZUPA", data, "TYPE_1");
		OfferItem itemA = new OfferItem(product, 1, discount);
		Money afterDiscount = itemA.getTotalCost();
		assertTrue(afterDiscount.equals(discountTemplate.price(template)));
	}
}
