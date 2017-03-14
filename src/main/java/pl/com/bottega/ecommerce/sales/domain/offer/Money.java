/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose
 * Tools | Templates and open the template in the editor.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.logging.Logger;

/**
 *
 * @author 187472
 */
public final class Money implements Comparable<Money> {

    private final static Logger log = Logger.getLogger("MoneyLogger");
    private BigDecimal amount;
    private final Currency currency;
    private static final Currency DEFAULT_CURRENCY = Currency.getInstance("PLN");
    private static final RoundingMode DEFAULT_MODE = RoundingMode.DOWN;
    private final RoundingMode mode;

    public BigDecimal getAmount() {
        return amount;
    }

    public Money(BigDecimal amount) {
        this.amount = amount;
        currency = DEFAULT_CURRENCY;
        mode = DEFAULT_MODE;
        this.amount.setScale(currency.getDefaultFractionDigits(), mode);
    }

    public Money(BigDecimal amount, RoundingMode mode) {
        this(amount, DEFAULT_CURRENCY, mode);
    }

    public Money(BigDecimal amount, Currency currency, RoundingMode mode) {
        this.amount = amount;
        this.currency = currency;
        this.mode = mode;
        this.amount.setScale(currency.getDefaultFractionDigits(), mode);
    }

    public Money(BigDecimal amount, Currency currency) {
        this(amount, currency, DEFAULT_MODE);
    }

    public Money(int amount) {
        this(BigDecimal.valueOf(amount), DEFAULT_CURRENCY, DEFAULT_MODE);
    }

    public Money(int i, Currency instance) {
        this(BigDecimal.valueOf(i), instance, DEFAULT_MODE);
    }

    public Money(int i, RoundingMode up) {
        this(BigDecimal.valueOf(i), DEFAULT_CURRENCY, up);
    }

    public Money(double d) {
        this.amount = BigDecimal.valueOf(d);
        currency = DEFAULT_CURRENCY;
        mode = DEFAULT_MODE;
    }

    public Money(Money subtract) {
        this.amount = subtract.amount;
        this.currency = subtract.currency;
        this.mode = subtract.mode;
        this.amount.setScale(currency.getDefaultFractionDigits(), mode);
    }

    public Money add(Money money) {
        if (money.currency != this.currency || money.mode != this.mode)
            return null;
        else {
            return new Money(this.amount.add(money.amount), this.currency, this.mode);
        }
    }

    public Money subtract(Money money) {
        if (money.currency != this.currency || money.mode != this.mode)
            return null;
        else {
            BigDecimal ref = amount.subtract(money.amount);
            return new Money(ref, this.currency, this.mode);
        }
    }

    public Money multiply(Money money) {
        if (money.currency != this.currency || money.mode != this.mode)
            return null;
        else {
            return new Money(this.amount.multiply(money.amount), this.currency, this.mode);
        }
    }

    public Money multiply(double money) {
        if (Double.isNaN(money))
            return null;
        else {
            BigDecimal def = new BigDecimal(money);
            def.setScale(currency.getDefaultFractionDigits(), mode);
            return new Money(this.amount.multiply(def), this.currency, this.mode);
        }
    }

    public Money divide(double money) {
        if (money == 0)
            return null;
        else {
            BigDecimal def = new BigDecimal(money);
            def.setScale(currency.getDefaultFractionDigits(), mode);
            return new Money(this.amount.divide(def), this.currency, this.mode);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((amount == null) ? 0 : amount.hashCode());
        result = prime * result + ((currency == null) ? 0 : currency.hashCode());
        result = prime * result + ((mode == null) ? 0 : mode.hashCode());
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
        Money other = (Money) obj;
        boolean result = (this.amount.equals(other.amount));
        log.info("Amount equals: " + result + " [" + this.amount + " : " + other.amount + "]");
        result = result && (this.currency.equals(other.currency));
        log.info("Currency equals: " + result + " [" + this.currency + " : " + other.currency + "]");
        result = result && (this.mode == other.mode);
        log.info("Mode equals: " + result + " [" + this.mode + " : " + other.mode + "]");
        return result;
    }

    @Override
    public String toString() {
        return amount + " " + currency.getSymbol();
    }

    public int compareTo(Money arg0) {
        int result = this.amount.compareTo(arg0.amount);
        log.info("Compare Amount:" + result);
        if (result != 0)
            return result;
        result = this.currency.getCurrencyCode().compareTo(arg0.currency.getCurrencyCode());
        log.info("Compare Currency:" + result);
        if (result != 0)
            return result;
        result = this.mode.compareTo(arg0.mode);
        log.info("Compare Mode:" + result);
        if (result != 0)
            return result;
        if (this == arg0)
            return 0;
        return 0;
    }

}
