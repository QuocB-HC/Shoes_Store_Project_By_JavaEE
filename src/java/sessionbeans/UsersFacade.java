/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Users;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ASUS
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "Shoes-Shopping-WebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Users findByEmail(String email) {
        try {
            return em.createQuery("SELECT user FROM Users user WHERE user.email = :email", Users.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void updateBasicInfo(Integer userId, String fullName, String phoneNumber, String gender, Date dateOfBirth) {
        em.createQuery("UPDATE Users u SET u.fullName = :fullName, u.phoneNumber = :phoneNumber, "
                + "u.gender = :gender, u.dateOfBirth = :dateOfBirth WHERE u.id = :id")
                .setParameter("fullName", fullName)
                .setParameter("phoneNumber", phoneNumber)
                .setParameter("gender", gender)
                .setParameter("dateOfBirth", dateOfBirth)
                .setParameter("id", userId)
                .executeUpdate();
    }

    public UsersFacade() {
        super(Users.class);
    }

    public void updateBasicInfo(Integer id, Date DateOfBirth, String phoneNumber, String gender, Date dateOfBirth) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
