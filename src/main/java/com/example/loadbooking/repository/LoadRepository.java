package com.example.loadbooking.repository;

import com.example.loadbooking.entity.Load;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoadRepository extends JpaRepository<Load, UUID> {
}
