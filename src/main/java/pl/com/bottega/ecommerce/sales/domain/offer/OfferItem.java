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
	private Money totalCost;
	
	// discount
	private String discountCause;
	private Money discount;

	public OfferItem(Product item, int quantity) {
		this(item, quantity, null, null);
	}

	public OfferItem(Product item, int quantity, 
			Money discount, String discountCause) {
		this.product = item;

		this.quantity = quantity;
		this.discount = discount;
		this.discountCause = discountCause;

		BigDecimal discountValue = new BigDecimal(0);
		if (discount != null) {
			discountValue = discountValue.subtract(discount.getValue());
		}

		this.totalCost = new Money(
			item.getPrice().getValue().multiply(
				new BigDecimal(quantity)
			).subtract(discountValue)
		);
	}

	public String getProductId() {
		return product.getId();
	}

	public Money getProductPrice() {
		return product.getPrice();
	}

	public String getProductName() {
		return product.getName();
	}

	public Date getProductSnapshotDate() {
		return product.getSnapshotDate();
	}

	public String getProductType() {
		return product.getType();
	}

	public Money getTotalCost() {
		return totalCost;
	}

	public String getTotalCostCurrency() {
		return totalCost.getCurrency();
	}

	public Money getDiscount() {
		return discount;
	}

	public String getDiscountCause() {
		return discountCause;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
			+ ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((product.getName() == null) ? 0 : product.getName().hashCode());
		result = prime * result + ((product.getPrice() == null) ? 0 : product.getPrice().hashCode());
		result = prime * result
			+ ((product.getId() == null) ? 0 : product.getId().hashCode());
		result = prime * result + ((product.getType() == null) ? 0 : product.getType().hashCode());
		result = prime * result + quantity;
		result = prime * result
			+ ((totalCost == null) ? 0 : totalCost.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		OfferItem other = (OfferItem) obj;
		if (discount == null) {
			if (other.discount != null) {
				return false;
			}
		} else if (!discount.equals(other.discount)) {
			return false;
		}
		if (product.getName() == null) {
			if (other.product.getName() != null) {
				return false;
			}
		} else if (!product.getName().equals(other.product.getName())) {
			return false;
		}
		if (product.getPrice() == null) {
			if (other.product.getPrice() != null) {
				return false;
			}
		} else if (!product.getPrice().equals(other.product.getPrice())) {
			return false;
		}
		if (product.getId() == null) {
			if (other.product.getId() != null) {
				return false;
			}
		} else if (!product.getId().equals(other.product.getId())) {
			return false;
		}
		if (product.getType() != other.product.getType()) {
			return false;
		}
		if (quantity != other.quantity) {
			return false;
		}
		if (totalCost == null) {
			if (other.totalCost != null) {
				return false;
			}
		} else if (!totalCost.equals(other.totalCost)) {
			return false;
		}
		return true;
	}

	/**
	 *
	 * @param item
	 * @param delta acceptable percentage difference
	 * @return
	 */
	public boolean sameAs(OfferItem other, double delta) {
		if (product.getName() == null) {
			if (other.product.getName() != null) {
				return false;
			}
		} else if (!product.getName().equals(other.product.getName())) {
			return false;
		}
		if (product.getPrice() == null) {
			if (other.product.getPrice() != null) {
				return false;
			}
		} else if (!product.getPrice().equals(other.product.getPrice())) {
			return false;
		}
		if (product.getId() == null) {
			if (other.product.getId() != null) {
				return false;
			}
		} else if (!product.getId().equals(other.product.getId())) {
			return false;
		}
		if (product.getType() != other.product.getType()) {
			return false;
		}

		if (quantity != other.quantity) {
			return false;
		}

		Money max, min;
		if (totalCost.compareTo(other.totalCost) > 0) {
			max = totalCost;
			min = other.totalCost;
		} else {
			max = other.totalCost;
			min = totalCost;
		}

		BigDecimal difference = max.getValue().subtract(min.getValue());
		BigDecimal acceptableDelta = max.getValue().multiply(new BigDecimal(delta / 100));

		return acceptableDelta.compareTo(difference) > 0;
	}

}
