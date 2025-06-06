/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "Discount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Discount.findAll", query = "SELECT d FROM Discount d")
    , @NamedQuery(name = "Discount.findById", query = "SELECT d FROM Discount d WHERE d.id = :id")
    , @NamedQuery(name = "Discount.findByPercentage", query = "SELECT d FROM Discount d WHERE d.percentage = :percentage")
    , @NamedQuery(name = "Discount.findByDayLeft", query = "SELECT d FROM Discount d WHERE d.dayLeft = :dayLeft")})
public class Discount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "percentage")
    private int percentage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "day_left")
    private int dayLeft;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne
    private Product productId;

    public Discount() {
    }

    public Discount(Integer id) {
        this.id = id;
    }

    public Discount(Integer id, int percentage, int dayLeft) {
        this.id = id;
        this.percentage = percentage;
        this.dayLeft = dayLeft;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getDayLeft() {
        return dayLeft;
    }

    public void setDayLeft(int dayLeft) {
        this.dayLeft = dayLeft;
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
        if (!(object instanceof Discount)) {
            return false;
        }
        Discount other = (Discount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Discount[ id=" + id + " ]";
    }
    
}
