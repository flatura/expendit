package code.flatura.expendit.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails extends User implements UserDetails {

    private List<String> userRoles;


    public CustomUserDetails(User user, List<String> userRoles) {
        super(user);
        this.userRoles = userRoles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roles = String.join(",", userRoles);
        /*
        String roles = userRoles
                .stream()
                .map(UserRole::getRole)
                .collect(Collectors.joining(","));*/
        System.out.println("!!!User roles are: " + userRoles);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
    }

    @Override
    public String getUsername() {
        return super.getName();
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
}
