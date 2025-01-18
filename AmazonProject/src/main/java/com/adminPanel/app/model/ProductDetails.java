package com.adminPanel.app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ProductDetails")
@Setter
@Getter
@NoArgsConstructor
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "expiration_date")
    private Date expiryDate;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "price")
    private double price;

    @Column(name = "available")
    private boolean isAvailable;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @OneToOne(mappedBy = "productDetails")
    private Product product;
}
