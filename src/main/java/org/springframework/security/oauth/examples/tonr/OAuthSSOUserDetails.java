package org.springframework.security.oauth.examples.tonr;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class OAuthSSOUserDetails extends User {
    private String email;
    private String name;
    private boolean newUser;

    public OAuthSSOUserDetails(String id, Collection<? extends GrantedAuthority> authorities) {
        super(id, "unused", authorities);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isNewUser() {
        return newUser;
    }

    public void setNewUser(boolean newUser) {
        this.newUser = newUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
