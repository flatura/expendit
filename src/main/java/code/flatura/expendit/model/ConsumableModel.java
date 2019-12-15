package code.flatura.expendit.model;

import javax.persistence.*;
import java.util.Objects;

import static code.flatura.expendit.util.Util.START_SEQ;

@Entity
@Table(name = "consumable_model")
public class ConsumableModel extends AbstractNamedEntity {

    @Id
    @SequenceGenerator(name = "consumable_model_seq", sequenceName = "consumable_model_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consumable_model_seq")
    private Integer id;

    @Column(name = "partnumber", nullable = false, unique = true)
    private String partNumber;

    @Column(name = "consumable_type_id", nullable = false)
    private int consumableTypeId;

    @Column(name = "resource", nullable = false)
    private Integer resource;

    public ConsumableModel(String partNumber, Integer consumableTypeId, Integer resource) {
        this.partNumber = partNumber;
        this.consumableTypeId = consumableTypeId;
        this.resource = resource;
    }

    public ConsumableModel(int id, String partNumber, Integer consumableTypeId, Integer resource) {
        this(partNumber, consumableTypeId, resource);
        this.id = id;
    }

    public ConsumableModel() {
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public Integer getConsumableTypeId() {
        return consumableTypeId;
    }

    public void setConsumableTypeId(Integer consumableTypeId) {
        consumableTypeId = consumableTypeId;
    }

    public Integer getResource() {
        return resource;
    }

    public void setResource(Integer resource) {
        this.resource = resource;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ConsumableModel that = (ConsumableModel) o;
        return partNumber.equals(that.partNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), partNumber);
    }

    @Override
    public String toString() {
        return "ConsumableModel{" +
                "partNumber='" + partNumber + '\'' +
                ", ConsumableTypeId=" + consumableTypeId +
                ", resource=" + resource +
                "} " + super.toString();
    }
}
