/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

/**
 *
 * @author 187472
 */
public class Money implements Comparable<Money> {

	private BigDecimal amount;
	private final Currency currency;
	private final Currency DEFAULT_CURRENCY = Currency.getInstance("PLN");
	private final RoundingMode DEFAULT_MODE = RoundingMode.DOWN;
	private final RoundingMode mode;

	public BigDecimal getAmount() {
		return amount;
	}

	public Money(BigDecimal amount) {
		this.amount = amount;
		currency = DEFAULT_CURRENCY;
		mode = DEFAULT_MODE;
	}

	public Money(BigDecimal amount, RoundingMode mode) {
		super();
		this.amount = amount;
		this.mode = mode;
		this.currency = DEFAULT_CURRENCY;
	}

	public Money(BigDecimal amount, Currency currency) {
		super();
		this.amount = amount;
		this.currency = currency;
		this.mode = DEFAULT_MODE;
	}

	public Money(BigDecimal amount, Currency currency, RoundingMode mode) {
		this.amount = amount;
		this.currency = currency;
		this.mode = mode;
	}

	public Money(int amount) {
		this.amount = BigDecimal.valueOf(amount);
		currency = DEFAULT_CURRENCY;
		mode = DEFAULT_MODE;
	}

	public Money(int i, Currency instance) {
		this(BigDecimal.valueOf(i), instance);
	}

	public Money(int i, RoundingMode up) {
		this(BigDecimal.valueOf(i), up);
	}
	
	public Money add(Money money){
		if(money.currency != this.currency || money.mode != this.mode)
			return null;
		else {
			return new Money(this.amount.add(money.amount), this.currency, this.mode);
		}
	}
	
	public Money subtract(Money money){
		if(money.currency != this.currency || money.mode != this.mode)
			return null;
		else {
			return new Money(this.amount.subtract(money.amount), this.currency, this.mode);
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
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (mode != other.mode)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return amount + " " + currency.getSymbol();
	}

	public int compareTo(Money arg0) {
		int result = arg0.amount.compareTo(this.amount);
		if(result != 0) return result;
		result = arg0.currency.getCurrencyCode().compareTo(this.currency.getCurrencyCode());
		if(result != 0) return result;
		result = arg0.mode.compareTo(this.mode);
		if(result != 0) return result;
		return 0;
	}

}
