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
		return null;
	}
	
	public Money subtract(Money money){
		return null;
	}

	@Override
	public String toString() {
		return amount + " " + currency;
	}

	public int compareTo(Money money) {
		return 0;
	}
}
