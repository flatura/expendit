package code.flatura.expendit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "consumable_model")
public class ConsumableModel extends AbstractNamedEntity {

    @Column(name = "partnumber", nullable = false, unique = true)
    private String partNumber;

    @Column(name = "consumable_type_id", nullable = false)
    private Integer ConsumableTypeId;

    @Column(name = "resource", nullable = false)
    private Integer resource;

    public ConsumableModel(String partNumber, Integer consumableTypeId, Integer resource) {
        this.partNumber = partNumber;
        ConsumableTypeId = consumableTypeId;
        this.resource = resource;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public Integer getConsumableTypeId() {
        return ConsumableTypeId;
    }

    public void setConsumableTypeId(Integer consumableTypeId) {
        ConsumableTypeId = consumableTypeId;
    }

    public Integer getResource() {
        return resource;
    }

    public void setResource(Integer resource) {
        this.resource = resource;
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
                ", ConsumableTypeId=" + ConsumableTypeId +
                ", resource=" + resource +
                "} " + super.toString();
    }
}
