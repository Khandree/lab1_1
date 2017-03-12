/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class OfferItem {

	// product
	private Product product;

	private int quantity;

	// offer price
	private Money offerPrice;

	// discount
	private Discount discount;

	public OfferItem(Product product, int quantity, Money offerPrice) {
		this(product, quantity, offerPrice, null);
	}

	public OfferItem(Product product, int quantity, Money offerPrice, Discount discount) {
		this.product = product;
		this.quantity = quantity;
		this.offerPrice = offerPrice;
		this.discount = discount;

		BigDecimal discountValue = new BigDecimal(0);
		if (discount != null)
			discountValue = discountValue.subtract(discount.getMoney().getValue());

		BigDecimal offerPriceValue;
		offerPriceValue = product.getProductPrice().getValue().multiply(new BigDecimal(quantity))
				.subtract(discountValue);
		this.offerPrice.setValue(offerPriceValue);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((offerPrice == null) ? 0 : offerPrice.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + quantity;
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
		OfferItem other = (OfferItem) obj;
		if (discount == null) {
			if (other.discount != null)
				return false;
		} else if (!discount.equals(other.discount))
			return false;
		if (offerPrice == null) {
			if (other.offerPrice != null)
				return false;
		} else if (!offerPrice.equals(other.offerPrice))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	/**
	 *
	 * @param item
	 * @param delta
	 *            acceptable percentage difference
	 * @return
	 */
	public boolean sameAs(OfferItem other, double delta) {
		if (product.getProductName() == null) {
			if (other.product.getProductName() != null)
				return false;
		} else if (!product.getProductName().equals(other.product.getProductName()))
			return false;
		if (offerPrice.getValue() == null) {
			if (other.offerPrice.getValue() != null)
				return false;
		} else if (!offerPrice.getValue().equals(other.offerPrice.getValue()))
			return false;
		if (product.getProductId() == null) {
			if (other.product.getProductId() != null)
				return false;
		} else if (!product.getProductId().equals(other.product.getProductId()))
			return false;
		if (product.getProductType() != other.product.getProductType())
			return false;

		if (quantity != other.quantity)
			return false;

		BigDecimal max, min;
		if (offerPrice.getValue().compareTo(other.offerPrice.getValue()) > 0) {
			max = offerPrice.getValue();
			min = other.offerPrice.getValue();
		} else {
			max = other.offerPrice.getValue();
			min = offerPrice.getValue();
		}

		BigDecimal difference = max.subtract(min);
		BigDecimal acceptableDelta = max.multiply(new BigDecimal(delta / 100));

		return acceptableDelta.compareTo(difference) > 0;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Money getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(Money offerPrice) {
		this.offerPrice = offerPrice;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

}
