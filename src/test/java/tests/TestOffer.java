package tests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import pl.com.bottega.ecommerce.sales.domain.offer.Discount;
import pl.com.bottega.ecommerce.sales.domain.offer.Money;
import pl.com.bottega.ecommerce.sales.domain.offer.Offer;
import pl.com.bottega.ecommerce.sales.domain.offer.OfferItem;
import pl.com.bottega.ecommerce.sales.domain.offer.Product;

public class TestOffer {

	@Test
	public void testOfferSame() {
		Date data = new Date();
		Money price = new Money(1);
		Discount discount = new Discount(10);
		Product productA = new Product("123", price, "ZUPA", data, "TYPE_1");
		Product productB = new Product("1234", price, "ZUPA", data, "TYPE_1");
		OfferItem itemA = new OfferItem(productA, 1, discount);
		OfferItem itemB = new OfferItem(productB, 1, discount);
		List<OfferItem> av = new ArrayList();
		av.add(itemA);
		av.add(itemB);
		List<OfferItem> uav = new ArrayList();
		Offer o1 = new Offer(av,uav);
		Offer o2 = new Offer(av,uav);
		Assert.assertTrue(o1.sameAs(o2, 0.1));
	}
	

}



