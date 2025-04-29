package warehouse.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "warehouses")
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

    @Override
    public String toString() {
        String info = String.format("Warehouse Info: WarehouseID = %s, Name = %s, Location = %s",
                warehouseID, name, location);
        return info;
    }
}
