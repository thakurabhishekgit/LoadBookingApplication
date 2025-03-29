package com.example.loadbooking.service;

import com.example.loadbooking.entity.Load;
import com.example.loadbooking.exception.InvalidRequestException;
import com.example.loadbooking.exception.ResourceNotFoundException;
import com.example.loadbooking.repository.LoadRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class LoadService {
    private final LoadRepository loadRepository;

    public LoadService(LoadRepository loadRepository) {
        this.loadRepository = loadRepository;
    }

    @Transactional
    public Load createLoad(Load load) {
        validateLoad(load);
        load.setDatePosted(LocalDateTime.now()); // Automatically set date posted
        return loadRepository.save(load);
    }

    public List<Load> getAllLoads() {
        return loadRepository.findAll();
    }

    public Load getLoadById(UUID id) {
        return loadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Load not found"));
    }

    @Transactional
    public Load updateLoad(UUID id, Load updatedLoad) {
        Load existingLoad = getLoadById(id);

        if (existingLoad.getStatus() == Load.Status.CANCELLED) {
            throw new InvalidRequestException("Cannot update a cancelled load");
        }

        validateLoad(updatedLoad);
        updatedLoad.setId(existingLoad.getId()); // Ensure the same ID remains
        return loadRepository.save(updatedLoad);
    }

    @Transactional
    public void deleteLoad(UUID id) {
        Load load = getLoadById(id);
        loadRepository.delete(load);
    }

    // Validate that all required fields are provided
    private void validateLoad(Load load) {
        if (load == null) {
            throw new InvalidRequestException("Load details cannot be null");
        }
        if (!StringUtils.hasText(load.getShipperId())) {
            throw new InvalidRequestException("Shipper ID is required");
        }
        if (!StringUtils.hasText(load.getLoadingPoint())) {
            throw new InvalidRequestException("Loading point is required");
        }
        if (!StringUtils.hasText(load.getUnloadingPoint())) {
            throw new InvalidRequestException("Unloading point is required");
        }
        if (load.getLoadingDate() == null) {
            throw new InvalidRequestException("Loading date is required");
        }
        if (load.getUnloadingDate() == null) {
            throw new InvalidRequestException("Unloading date is required");
        }
        if (!StringUtils.hasText(load.getProductType())) {
            throw new InvalidRequestException("Product type is required");
        }
        if (!StringUtils.hasText(load.getTruckType())) {
            throw new InvalidRequestException("Truck type is required");
        }
        if (load.getNoOfTrucks() <= 0) {
            throw new InvalidRequestException("Number of trucks must be greater than zero");
        }
        if (load.getWeight() <= 0) {
            throw new InvalidRequestException("Weight must be greater than zero");
        }
    }
}
