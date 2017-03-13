/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Logger;

public class OfferItem {

    // product
    private final static Logger log = Logger.getLogger("OfferItemLogger");
    private Product product;
    private int quantity;
    private Money totalCost;
    private Discount discount;

    public OfferItem(Product product, int quantity) {
        this(product, quantity, null);
    }

    public OfferItem(Product product, int quantity, Discount discount) {
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;
        countTotalCost();
    }

    // two ways to discout, for
    private Money countTotalCost() {
        if (discount != null)
            totalCost = discount.price(product.getProductPrice()).multiply(quantity);
        else
            totalCost = product.getProductPrice().multiply(quantity);
        return totalCost;
    }

    public Money getTotalCost() {
        return totalCost;
    }

    public Discount getDiscount() {
        return discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((discount == null) ? 0 : discount.hashCode());
        result = prime * result + ((product == null) ? 0 : product.hashCode());
        result = prime * result + quantity;
        result = prime * result + ((totalCost == null) ? 0 : totalCost.hashCode());
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
        if (quantity != other.quantity)
            return false;
        if (totalCost == null) {
            if (other.totalCost != null)
                return false;
        } else if (!totalCost.equals(other.totalCost))
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

        if (quantity != other.quantity)
            return false;

        Money max, min;
        if (totalCost.compareTo(other.totalCost) > 0) {
            max = totalCost;
            min = other.totalCost;
        } else {
            max = other.totalCost;
            min = totalCost;
        }

        Money difference = max.subtract(min);
        Money acceptableDelta = max.multiply(delta / 100);
        log.info("OfferItem sameAs difference: " + difference);
        log.info("OfferItem sameAs acceptableDelta: " + acceptableDelta);
        boolean result = acceptableDelta.compareTo(difference) > 0;
        log.info("OfferItem sameAs: " + result + "[" + this.toString() + " : " + other.toString() + "]");
        return result;
    }

    @Override
    public String toString() {
        return "OfferItem [product=" + product + ", quantity=" + quantity + ", totalCost=" + totalCost + ", discount=" +
                discount + "]";
    }

}
