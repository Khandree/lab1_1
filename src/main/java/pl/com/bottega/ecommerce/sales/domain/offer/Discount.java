package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

/**
 * Created by adrian on 2017-03-12.
 */
public class Discount {
    private Money money;
    private String discountCause;

    public Discount(Money money, String discountCause) {
        this.money = money;
        this.discountCause = discountCause;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public String getDiscountCause() {
        return discountCause;
    }

    public void setDiscountCause(String discountCause) {
        this.discountCause = discountCause;
    }
}
