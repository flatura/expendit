package code.flatura.expendit.model;

import java.util.Objects;

public class ConsumableModel extends AbstractNamedEntity {
    private String partNumber;
    private Integer ConsumableTypeId;
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
