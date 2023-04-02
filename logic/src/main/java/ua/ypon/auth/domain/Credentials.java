package ua.ypon.auth.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * net.ukr@caravell 28/03/2023
 */
@Entity
public class Credentials {
    @Id
    private String email;
    private String password;

    @OneToOne(mappedBy = "credentials")
    private ShopUser shopUser;

    public ShopUser getUser() {
        return shopUser;
    }

    public void setUser(ShopUser shopUser) {
        this.shopUser = shopUser;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
