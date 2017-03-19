package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {
    // discount
    private String discountCause;

    private Money money;


    public Discount (Money money, String discountCause) {
        this.money = money;
        this.discountCause = discountCause;
    }

    public Money money(){
        return money;
    }

    public String getDiscountCause(){
        return discountCause;
    }
}