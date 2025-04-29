package warehouse.service;

import warehouse.model.WarehouseData;
import warehouse.repository.WarehouseRepository;

import java.util.List;

public class WarhouseService {
    private WarehouseRepository repository;

    public void newLocation(WarehouseData warehouse) {
        repository.save(warehouse);
    }

    public List<WarehouseData> getAllWarehouses() {
        return repository.findAll();
    }

    public WarehouseData getWarehouseByID(String warehouseID) {
        return repository.findByWarehouseID(warehouseID);
    }

    public void deleteWarehouseByID(String warehouseID) {
        repository.delete(repository.findByWarehouseID(warehouseID));
    }
}
