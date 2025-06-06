/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "Product_Variant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductVariant.findAll", query = "SELECT p FROM ProductVariant p")
    , @NamedQuery(name = "ProductVariant.findById", query = "SELECT p FROM ProductVariant p WHERE p.id = :id")
    , @NamedQuery(name = "ProductVariant.findBySize", query = "SELECT p FROM ProductVariant p WHERE p.size = :size")
    , @NamedQuery(name = "ProductVariant.findByColor", query = "SELECT p FROM ProductVariant p WHERE p.color = :color")
    , @NamedQuery(name = "ProductVariant.findByStockQuantity", query = "SELECT p FROM ProductVariant p WHERE p.stockQuantity = :stockQuantity")})
public class ProductVariant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "size")
    private String size;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock_quantity")
    private int stockQuantity;
    @OneToMany(mappedBy = "productVariantId")
    private Collection<OrderDetails> orderDetailsCollection;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne
    private Product productId;

    public ProductVariant() {
    }

    public ProductVariant(Integer id) {
        this.id = id;
    }

    public ProductVariant(Integer id, String size, String color, int stockQuantity) {
        this.id = id;
        this.size = size;
        this.color = color;
        this.stockQuantity = stockQuantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @XmlTransient
    public Collection<OrderDetails> getOrderDetailsCollection() {
        return orderDetailsCollection;
    }

    public void setOrderDetailsCollection(Collection<OrderDetails> orderDetailsCollection) {
        this.orderDetailsCollection = orderDetailsCollection;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductVariant)) {
            return false;
        }
        ProductVariant other = (ProductVariant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProductVariant[ id=" + id + " ]";
    }
    
}
