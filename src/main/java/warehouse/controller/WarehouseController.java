package warehouse.controller;

import org.springframework.web.bind.annotation.*;
import warehouse.model.ProductData;
import warehouse.model.WarehouseData;
import warehouse.service.ProductService;
import warehouse.service.WarehouseService;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    private final WarehouseService service;
    private final ProductService productService;

    public WarehouseController(WarehouseService service, ProductService productService) {
        this.service = service;
        this.productService = productService;
    }

    @GetMapping("")
    public String getAllWarehouses() {
        System.out.println(service.getAllWarehouses());
        String ausgabe = "";
        for (WarehouseData warehouseData : service.getAllWarehouses()) {
            ausgabe += warehouseData.toString();
            ausgabe += "\n";
            ausgabe += productService.getProductsByWarehouseID(warehouseData.getWarehouseID());
        }
        return ausgabe;
    }

    @PostMapping
    public WarehouseData createWarehouse(@RequestBody WarehouseData data) {
        service.newLocation(data);
        return data;
    }

    @GetMapping("/{id}")
    public String getWarehouseById(@PathVariable String id) {
        String ausgabe = "";
        ausgabe += service.getWarehouseByID(id).toString();
        ausgabe += "\n";
        for (ProductData productData : productService.getProductsByWarehouseID(id)) {
            ausgabe += productData.toString() + "\n";
        }
        return ausgabe;
    }

    @DeleteMapping("/{id}")
    public void deleteWarehouseById(@PathVariable String id) {
        service.deleteWarehouseByID(id);
    }
}
