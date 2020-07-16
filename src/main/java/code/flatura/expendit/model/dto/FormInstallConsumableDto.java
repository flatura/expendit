package code.flatura.expendit.model.dto;

import java.io.Serializable;

public class FormInstallConsumableDto extends AbstractBaseDto implements Serializable {
    private int model_id;
    private int count_to_install;
    private int room_id;

    public FormInstallConsumableDto(int model_id, int count_to_install, int room_id) {
        this.model_id = model_id;
        this.count_to_install = count_to_install;
        this.room_id = room_id;
    }

    public int getModel_id() {
        return model_id;
    }

    public int getCount_to_install() {
        return count_to_install;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public void setCount_to_install(int count_to_install) {
        this.count_to_install = count_to_install;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }
}
