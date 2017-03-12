package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

/**
 * Created by adrian on 2017-03-12.
 */
public class Discount {
    private String discountCause;

    private BigDecimal discount;

    public String getDiscountCause(){
        return discountCause;
    }

    public void setDiscountCause(String discountCause){
        this.discountCause = discountCause;
    }

    public BigDecimal getDiscount(){
        return discount;
    }

    public void setDiscount(BigDecimal discount){
        this.discount = discount;
    }
}
