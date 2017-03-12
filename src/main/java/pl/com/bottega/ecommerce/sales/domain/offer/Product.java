package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by adrian on 2017-03-12.
 */
public class Product {

    private String productId;

    private String productName;

    private Date productSnapshotDate;

    private String productType;

    private Money productPrice;

    public Product(String productId, String productName, Date productSnapshotDate, String productType,
                   Money productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productSnapshotDate = productSnapshotDate;
        this.productType = productType;
        this.productPrice = productPrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getProductSnapshotDate() {
        return productSnapshotDate;
    }

    public void setProductSnapshotDate(Date productSnapshotDate) {
        this.productSnapshotDate = productSnapshotDate;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Money getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Money productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (null == obj)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (null == productName) {
            if (null != other.productName)
                return false;
        } else if (!this.productName.equals(other.productName))
            return false;
        if (null == productPrice) {
            if (null != other.productPrice)
                return false;
        } else if (this.productPrice != other.productPrice)
            return false;
        if (productId == null) {
            if (other.productId != null)
                return false;
        } else if (!productId.equals(other.productId))
            return false;
        if (null == this.productType) {
            if (null != other.productType)
                return false;

        } else if (productType != other.productType)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 0;
        result = prime * result + ((productName == null) ? 0 : productName.hashCode());
        result = prime * result + ((productPrice == null) ? 0 : productPrice.hashCode());
        result = prime * result + ((productId == null) ? 0 : productId.hashCode());
        result = prime * result + ((productType == null) ? 0 : productType.hashCode());
        return result;
    }
}
