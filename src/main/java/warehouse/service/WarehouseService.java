package warehouse.service;

import org.springframework.stereotype.Service;
import warehouse.model.WarehouseData;
import warehouse.repository.WarehouseRepository;

import java.util.List;

@Service
public class WarehouseService {
    private WarehouseRepository repository;

    public WarehouseService(WarehouseRepository repository) {
        this.repository = repository;
    }

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
