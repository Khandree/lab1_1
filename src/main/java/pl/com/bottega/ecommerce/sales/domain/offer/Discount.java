package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {
    // discount
    private String discountCause;

    private Money value;


    public Discount (Money money, String discountCause) {
        this.value = money;
        this.discountCause = discountCause;
    }

    public Money money(){
        return value;
    }

    public String getDiscountCause(){
        return discountCause;
    }
}