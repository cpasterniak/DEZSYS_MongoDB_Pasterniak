package warehouse.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import warehouse.model.ProductData;
import warehouse.model.WarehouseData;

public interface WarehouseRepository extends MongoRepository<WarehouseData, String> {

    public WarehouseData findByWarehouseID(String warehouseID);
    public List<ProductData> findProductsByWarehouseID(String warehouseID);

 }
