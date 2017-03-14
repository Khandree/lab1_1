/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author 194938
 */
public class Product {

    private String productId;
    private String productName;
    private Date productSnapshotDate;
    private String productType;
    private int quantity;
    private BigDecimal totalCost;

    public String getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }

    public Date getProductSnapshotDate() {
        return productSnapshotDate;
    }

    public String getProductType() {
        return productType;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }
    public int getQuantity() {
        return quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((productId == null) ? 0 : productId.hashCode());
        result = prime * result + ((productName == null) ? 0 : productName.hashCode());
        result = prime * result + ((productSnapshotDate == null) ? 0 : productSnapshotDate.hashCode());
        result = prime * result
                + ((productType == null) ? 0 : productType.hashCode());
        result = prime * result + ((totalCost == null) ? 0 : totalCost.hashCode());
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
        Product other = (Product) obj;
        if (productId == null) {
            if (other.productId != null)
                return false;
        } else if (!productId.equals(other.productId))
            return false;
        if (productName == null) {
            if (other.productName != null)
                return false;
        } else if (!productName.equals(other.productName))
            return false;
        if (productSnapshotDate == null) {
            if (other.productSnapshotDate != null)
                return false;
        } else if (!productSnapshotDate.equals(other.productSnapshotDate))
            return false;
        if (productType != other.productType)
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
    
}
