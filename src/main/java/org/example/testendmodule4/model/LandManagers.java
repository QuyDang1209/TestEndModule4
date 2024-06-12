package org.example.testendmodule4.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LandManagers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    @ManyToOne
    @JoinColumn(name = "Customer_id")
    private Customers customer;
    private String type;
    private String date;
    private double price;
    private double acreage;

}
