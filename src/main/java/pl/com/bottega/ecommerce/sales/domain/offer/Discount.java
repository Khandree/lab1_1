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
public class Discount {
    private String discountCause;
    private BigDecimal discountValue;

    public BigDecimal getDiscount() {
        return discountValue;
    }

    public String getDiscountCause() {
        return discountCause;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((discountValue == null) ? 0 : discountValue.hashCode());
        result = prime * result + ((discountCause == null) ? 0 : discountCause.hashCode());
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
        Discount disc = (Discount) obj;
        if (discountValue == null) {
            if (disc.discountValue != null)
                return false;
        } else if (!discountValue.equals(disc.discountValue))
            return false;
        if (discountCause == null) {
            if (disc.discountCause != null)
                return false;
        } else if (!discountCause.equals(disc.discountCause))
            return false;
        return true;
    }
    
}
