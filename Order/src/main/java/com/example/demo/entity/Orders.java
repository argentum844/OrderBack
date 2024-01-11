package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name="title")
    private String Title;

    @Column(name = "NameClient")
    private String NameClient;

    @Column(name="TypeConnection")
    private String TypeConnection;

    @Column(name="description")
    private String Description;

    @Column(name="price")
    private int Price;

    @Column(name="requirement")
    private String Requirement;

    @Column(name = "image")
    private String image;
}
