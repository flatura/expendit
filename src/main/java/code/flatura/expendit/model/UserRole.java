package code.flatura.expendit.model;

import javax.persistence.*;

@Entity
@Table(name = "users_roles", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role"}, name = "user_roles_idx")})
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_role_id")
    private Integer user_role_id;

    @Column(name = "user_id", nullable = false)
    private Integer user_id;

    @Column(name = "role", nullable = false)
    private String role;

    public UserRole() {
    }

    public UserRole(Integer user_id, String role) {
        this.user_id = user_id;
        this.role = role;
    }

    public Integer getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(Integer user_role_id) {
        this.user_role_id = user_role_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
