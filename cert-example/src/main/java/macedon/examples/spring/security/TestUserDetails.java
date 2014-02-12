package macedon.examples.spring.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 */
public class TestUserDetails implements UserDetails {

    private List<String> authorizations;
    private String userName;
    private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    {
        authorities.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_USER";
            }
        });
    }

    public TestUserDetails(String userName, List<String> authorizations) {
        this.userName = userName;
        this.authorizations = authorizations;
    }

    public List<String> getAuthorizations() {
        return this.authorizations;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
