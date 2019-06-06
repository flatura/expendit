package code.flatura.expendit.model;

public class Consumable extends AbstractNamedEntity {
    private String contract;
    private Integer price;
    private Integer consumableTypeId;
    private Integer consumableModelId;
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
