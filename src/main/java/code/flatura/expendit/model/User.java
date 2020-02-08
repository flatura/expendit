package code.flatura.expendit.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

import static code.flatura.expendit.util.Util.START_SEQ;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "users_unique_email_idx")})
public class User extends AbstractNamedEntity {

    @Id
    @SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    private Integer id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    private boolean enabled = true;

    @Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()")
    private LocalDate registered;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User() {
    }

    public User(User u) {
        this(u.getId(), u.getName(), u.getEmail(), u.getPassword(), u.isEnabled(), u.getRegistered(), u.roles);
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User(Integer id, String name, String email, String password, Set<Role> roles) {
        this(id, name, email, password, true, LocalDate.now(), roles);
    }

    public User(Integer id, String name, String email, String password, boolean enabled, LocalDate registered, Set<Role> roles) {
        super(id, name);
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.registered = registered;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDate registered) {
        this.registered = registered;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getPassword() {
        return password;
    }
}