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
public class Discount {

	private String discountCause;
	private Money valueDiscount;
	private final DiscountType type;
	private double procentageDiscount;

	public Discount(Money discountValue) {
		this.valueDiscount = discountValue;
		if (discountValue != null)
			this.type = DiscountType.VALUE;
		else {
			this.type = DiscountType.PROCENTAGE;
			procentageDiscount = 0;
		}
	}

	public Discount(double procentageDiscount) {
		this.procentageDiscount = procentageDiscount;
		this.type = DiscountType.PROCENTAGE;
	}

	public Money price(Money currentPrice) {
		switch (type) {
		case PROCENTAGE:
			return new Money(currentPrice.subtract(currentPrice.multiply(procentageDiscount).divide(100)));
		case VALUE:
			return new Money(currentPrice.subtract(valueDiscount));
		default:
			return currentPrice;
		}
	}

	@Override
	public String toString() {
		return "Discount [discountCause=" + discountCause + ", valueDiscount=" + valueDiscount + ", type=" + type.name()
				+ ", procentageDiscount=" + procentageDiscount + "]";
	}

}
