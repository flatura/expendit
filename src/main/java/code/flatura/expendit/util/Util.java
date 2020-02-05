package code.flatura.expendit.util;

import code.flatura.expendit.model.User;
import code.flatura.expendit.model.dto.UserDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

public class Util {
    public static final int START_SEQ = 100000;

    public static User createUserFromUserDto(UserDto newUser) {
        return new User(null, newUser.getName(), newUser.getEmail().toLowerCase(), newUser.getPassword(), true, LocalDate.now(), newUser.getRoles());
    }

    public static UserDto asUserDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail(), "********", user.getRoles(), user.getRegistered());
    }

    public static User updateUserFromDto(User user, UserDto userTo) {
        user.setName(userTo.getName());
        user.setEmail(userTo.getEmail().toLowerCase());
        user.setPassword(userTo.getPassword());
        user.setRoles(userTo.getRoles());
        user.setRegistered(userTo.getRegistered());
        return user;
    }

    public static User prepareUserToSave(User user, PasswordEncoder passwordEncoder) {
        String password = user.getPassword();
        user.setPassword(StringUtils.isEmpty(password) ? password : passwordEncoder.encode(password));
        user.setEmail(user.getEmail().toLowerCase());
        return user;
    }
}
