/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.ProductVariant;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ASUS
 */
@Stateless
public class ProductVariantFacade extends AbstractFacade<ProductVariant> {

    @PersistenceContext(unitName = "Shoes-Shopping-WebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<ProductVariant> getProductVariantByProductId(int id) {
        return em.createQuery(
                "SELECT productVariant FROM ProductVariant productVariant WHERE productVariant.productId.id = :productId", ProductVariant.class)
                .setParameter("productId", id)
                .getResultList();
    }

    public ProductVariantFacade() {
        super(ProductVariant.class);
    }

}
