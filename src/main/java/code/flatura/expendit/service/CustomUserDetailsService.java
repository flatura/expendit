package code.flatura.expendit.service;

import code.flatura.expendit.model.CustomUserDetails;
import code.flatura.expendit.model.Role;
import code.flatura.expendit.model.User;
import code.flatura.expendit.model.UserRole;
import code.flatura.expendit.repository.UserRepository;
import code.flatura.expendit.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public UserRoleRepository getUserRoleRepository() {
        return userRoleRepository;
    }

    public UserDetails loadUserByUsername(String userName) {
        User user = userRepository.findByName(userName);
        System.out.println("Got user: " + user.toString());
        if (!user.equals(null)) {
            List<String> userRoles = userRoleRepository.findByName(userName);
            return new CustomUserDetails(user, userRoles);
        } else throw new UsernameNotFoundException("There's no user with name " + userName);
    }
}
