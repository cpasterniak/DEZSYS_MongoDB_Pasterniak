package warehouse.service;

import org.springframework.stereotype.Service;
import warehouse.model.ProductData;
import warehouse.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void newProduct (ProductData productData) {
        repository.save(productData);
    }

    public List<ProductData> getAllProducts() {
        return repository.findAll();
    }

    public List<ProductData> getProductsByWarehouseID(String warehouseID) {
        return repository.findByWarehouseID(warehouseID);
    }

    public ProductData getProductByID(String productID) {
        return repository.findByProductID(productID);
    }

    public void deleteProductByID(String productID) {
        repository.delete(repository.findByProductID(productID));
    }
}
