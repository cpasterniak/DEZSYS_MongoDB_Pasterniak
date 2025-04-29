package warehouse.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import warehouse.model.ProductData;

import java.util.List;

public interface ProductRepository extends MongoRepository<ProductData, String> {
    public List<ProductData> findByWarehouseID(String warehouseID);
    public ProductData findByProductID(String productID);
}
