
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import junit.framework.Assert;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import pl.com.bottega.ecommerce.sales.domain.offer.MoneyAmount;
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
        MoneyAmount amount = new MoneyAmount("Euro", BigDecimal.ONE);
        Product productA = new Product("123", amount, "ZUPA", data, "TYPE_1");
        Product productB = new Product("123", amount, "ZUPA", data, "TYPE_1");
        assertEquals(productA, productB);
    }

    @Test
    public void testOfferItemAreSame() {
        Date data = new Date();
        MoneyAmount amount = new MoneyAmount("Euro", BigDecimal.ONE);
        Product product = new Product("123", amount, "ZUPA", data, "TYPE_1");
        OfferItem itemA = new OfferItem(product, 0, BigDecimal.ONE, "Because");
        OfferItem itemB = new OfferItem(product, 0, BigDecimal.ONE, "Because");
        assertEquals(itemB, itemA);
    }
}
