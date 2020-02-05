package code.flatura.expendit.model.dto;

import code.flatura.expendit.model.Role;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

public class UserDto extends AbstractBaseDto implements Serializable {
    private String name;

    private String email;

    private String password;

    private Set<Role> roles;

    private LocalDate registered;

    public UserDto(Integer id, String name, String email, String password, Set<Role> roles, LocalDate registered) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.registered = registered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public LocalDate getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDate registered) {
        this.registered = registered;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", registered=" + registered +
                ", id=" + id +
                "} " + super.toString();
    }
}
