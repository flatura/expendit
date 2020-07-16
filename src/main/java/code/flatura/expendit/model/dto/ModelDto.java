package code.flatura.expendit.model.dto;

import java.io.Serializable;

public class ModelDto extends BaseDto implements Serializable {
    private final Integer count;

    public ModelDto(Integer id, String name, Integer count) {
        super(id, name);
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }
}
