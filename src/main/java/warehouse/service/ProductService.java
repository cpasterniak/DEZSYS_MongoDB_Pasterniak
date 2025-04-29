package warehouse.service;

import warehouse.model.ProductData;
import warehouse.repository.ProductRepository;

import java.util.List;

public class ProductService {
    private ProductRepository repository;

    public void newProduct (ProductData productData) {
        repository.save(productData);
    }

    public List<ProductData> getAllProducts() {
        return repository.findAll();
    }

    public ProductData getProductByID(String productID) {
        return repository.findByProductID(productID);
    }

    public void deleteProductByID(String productID) {
        repository.delete(repository.findByProductID(productID));
    }
}
