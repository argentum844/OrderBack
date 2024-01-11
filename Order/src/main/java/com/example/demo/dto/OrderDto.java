package com.example.demo.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private String Title;

    private String NameClient;

    private String TypeConnection;

    private String Description;

    private int Price;

    private String Requirement;

    private String image;
}
