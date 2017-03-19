package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Date;

public class Product {
    // product

    private String id;
    private Money money;
    private String name;
    private Date snapshotDate;
    private String type;

    public Product(String id, Money money, String name, Date snapshotDate, String type) {
        this.id = id;
        this.money = money;
        this.name = name;
        this.snapshotDate = snapshotDate;
        this.type = type;

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((money == null) ? 0 : money.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((snapshotDate == null) ? 0 : snapshotDate.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        if (money == null) {
            if (other.money != null)
                return false;
        } else if (!money.equals(other.money))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (snapshotDate == null) {
            if (other.snapshotDate != null)
                return false;
        } else if (!snapshotDate.equals(other.snapshotDate))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }

    public String getId() {
        return id;
    }

    public Money getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public String getType() {
        return type;
    }
}