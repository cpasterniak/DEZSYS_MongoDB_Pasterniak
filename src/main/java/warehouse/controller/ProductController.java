package warehouse.controller;

import org.springframework.web.bind.annotation.*;
import warehouse.model.ProductData;
import warehouse.repository.ProductRepository;
import warehouse.service.ProductService;
import warehouse.service.WarehouseService;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService service;
    private WarehouseService warehouseService;

    public ProductController(ProductService service, WarehouseService warehouseService) {
        this.service = service;
        this.warehouseService = warehouseService;
    }

    @GetMapping("")
    public String getAllProducts() {
        String response = "";
        for(ProductData productData: service.getAllProducts()) {
            response += productData.toString() + "\n";
            response += warehouseService.getWarehouseByID(productData.getWarehouseID());
        }
        return response;
    }

    @PostMapping("")
    public void addProduct(@RequestBody ProductData productData) {
        service.newProduct(productData);
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable String id) {
        String response = "";
        response += service.getProductByID(id).toString() + "\n";
        response += warehouseService.getWarehouseByID(service.getProductByID(id).getWarehouseID()).toString();
        return response;
    }
}
