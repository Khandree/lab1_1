package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

/**
 * Created by adrian on 2017-03-12.
 */
public class Money {
    private BigDecimal value;
    private String currency;

    public Money(BigDecimal value, String currency){
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getValue(){
        return value;
    }

    public void setValue(BigDecimal value){
        this.value = value;
    }

    public String getCurrency(){
        return currency;
    }

    public void setCurrency(String currency){
        this.currency = currency;
    }
}
