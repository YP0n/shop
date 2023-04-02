package ua.ypon.auth.ejb;

import org.apache.commons.lang3.StringUtils;
import ua.ypon.auth.domain.Credentials;
import ua.ypon.auth.domain.ShopUser;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * net.ukr@caravell 28/03/2023
 */

@Stateless
@LocalBean
public class AuthenticationManager {
    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;

    public ShopUser.Role login(String email, String password){
        if(StringUtils.isEmpty(email) || StringUtils.isEmpty(password)){
            return null;
        }

        Credentials credentials = entityManager.find(Credentials.class, email);
        if(credentials == null) {
            return null;
        }

        if(!password.equals(credentials.getPassword())){
        return null;
        }
        ShopUser shopUser = credentials.getUser();
        if(shopUser == null) {
            return null;
        }
        return shopUser.getRole();
    }
}
