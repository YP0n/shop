package ua.ypon.auth.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * net.ukr@caravell 28/03/2023
 */
@Entity
public class ShopUser {
    public enum Role{
        USER,
        ADMIN
    }
    @Id
    private Long id;
    private String name;
    private Role role;

    @OneToOne
    private Credentials credentials;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
