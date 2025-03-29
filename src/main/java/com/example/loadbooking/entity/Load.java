package com.example.loadbooking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Load {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String shipperId;
    private String loadingPoint;
    private String unloadingPoint;
    private LocalDateTime loadingDate;
    private LocalDateTime unloadingDate;
    private String productType;
    private String truckType;
    private int noOfTrucks;
    private double weight;
    private String comment;
    private LocalDateTime datePosted;

    @Enumerated(EnumType.STRING)
    private Status status = Status.POSTED;

    public enum Status {
        POSTED, BOOKED, CANCELLED
    }
}
