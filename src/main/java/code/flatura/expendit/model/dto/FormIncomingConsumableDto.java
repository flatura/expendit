package code.flatura.expendit.model.dto;

import java.io.Serializable;

public class FormIncomingConsumableDto extends AbstractBaseDto implements Serializable {
    private int modelId;
    private String name;
    private int incomeCount;
    private int price;
    private int roomId;
    private String contract;

    public FormIncomingConsumableDto(int modelId, String name, int incomeCount, int price, int roomId, String contract) {
        this.modelId = modelId;
        this.name = name;
        this.incomeCount = incomeCount;
        this.price = price;
        this.roomId = roomId;
        this.contract = contract;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIncomeCount() {
        return incomeCount;
    }

    public void setIncomeCount(int incomeCount) {
        this.incomeCount = incomeCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }
}
