package code.flatura.expendit.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractNamedEntity extends AbstractBaseEntity implements Serializable {

    @Column(name = "name", nullable = false)
    protected String name;

    protected AbstractNamedEntity() {
    }

    protected AbstractNamedEntity(Integer id, String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("Entity %s ('%s')", getClass().getName(), name);
    }
}