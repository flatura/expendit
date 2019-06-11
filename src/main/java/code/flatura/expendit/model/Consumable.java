package code.flatura.expendit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "consumable")
public class Consumable extends AbstractNamedEntity {

    @Column(name = "contract")
    private String contract;

    @Column(name = "price")
    private Integer price;

    @Column(name = "consumable_model_id")
    private Integer consumableTypeId;

    @Column(name = "consumable_type_id")
    private Integer consumableModelId;

    @Column(name = "status")
    private Integer status;

    public Consumable(String contract, Integer price, Integer consumableTypeId, Integer consumableModelId, Integer status) {
        this.contract = contract;
        this.price = price;
        this.consumableTypeId = consumableTypeId;
        this.consumableModelId = consumableModelId;
        this.status = status;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getConsumableTypeId() {
        return consumableTypeId;
    }

    public void setConsumableTypeId(Integer consumableTypeId) {
        this.consumableTypeId = consumableTypeId;
    }

    public Integer getConsumableModelId() {
        return consumableModelId;
    }

    public void setConsumableModelId(Integer consumableModelId) {
        this.consumableModelId = consumableModelId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}
