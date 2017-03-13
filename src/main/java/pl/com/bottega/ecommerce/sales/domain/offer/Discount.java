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
	private final Money discount;
	private final DiscountType type;

	public Discount(Money discountPrice, DiscountType type) {
		super();
		this.discount = discountPrice;
		this.type = type;
	}

	public Money price(Money currentPrice){
		switch(type){
		case PROCENTAGE:
			return new Money(currentPrice.subtract(currentPrice.multiply(discount).divide(100)).getAmount());
		case VALUE:
			return new Money(currentPrice.subtract(discount).getAmount());
		default:
			return currentPrice;
		}
	}
	
}
