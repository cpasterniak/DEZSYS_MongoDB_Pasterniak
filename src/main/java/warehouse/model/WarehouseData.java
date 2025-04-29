package warehouse.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
public class WarehouseData {
    @Id
    @Getter
    @Setter
    private String warehouseID;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String location;
}
