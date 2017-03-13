/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

/**
 *
 * @author 194938
 */
public class Money {
    private String currency;

    public Money(String currency) {
        this.currency = currency;
    }
    public String getCurrency() {
        return currency;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((currency == null) ? 0 : currency.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Money mon = (Money) obj;
        if (currency == null) {
            if (mon.currency != null)
                return false;
        } else if (!currency.equals(mon.currency))
            return false;
        return true;
    }
}
