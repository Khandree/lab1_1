/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

/**
 *
 * @author 187472
 */
public class MoneyAmount {
    private final String currency;
    private final BigDecimal amount;

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public MoneyAmount(String currency, BigDecimal amount) {
        this.currency = currency;
        this.amount = amount;
    }
}
