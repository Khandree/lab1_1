package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by adrian on 2017-03-12.
 */
public class Product {

    private BigDecimal productPrice;

    private String productName;

    private Date productSnapshotDate;

    private String productType;

    public Product(BigDecimal productPrice, String productName, Date productSnapshotDate, String productType) {
        this.productPrice = productPrice;
        this.productName = productName;
        this.productSnapshotDate = productSnapshotDate;
        this.productType = productType;
    }

    public BigDecimal getProductPrice(){
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice){
        this.productPrice = productPrice;
    }

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public Date getProductSnapshotDate(){
        return productSnapshotDate;
    }

    public void setProductSnapshotDate(Date productSnapshotDate){
        this.productSnapshotDate = productSnapshotDate;
    }

    public String getProductType(){
        return productType;
    }

    public void setProductType(String productType){
        this.productType = productType;
    }
}
