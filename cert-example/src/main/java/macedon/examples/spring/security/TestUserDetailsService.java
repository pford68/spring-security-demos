package macedon.examples.spring.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class TestUserDetailsService implements UserDetailsService {

    private List<String> authorizations = new ArrayList<String>();
    {
        authorizations.add("EX-5678");
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (s.contains("pford")){
            return new TestUserDetails("pford", authorizations);
        }
        throw new UsernameNotFoundException(String.format("The user %s is not valid.", s));
    }

}
