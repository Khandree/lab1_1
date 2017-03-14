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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (null == obj)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Money other = (Money) obj;
        if (null == this.value) {
            if (null != other.value)
                return false;
        } else if (this.value != other.value)
            return false;
        if (null == this.currency) {
            if (null != other.currency)
                return false;
        } else if (this.currency != other.currency)
            return false;

        return true;
    }
}
