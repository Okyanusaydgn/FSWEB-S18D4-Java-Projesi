package com.workintech.s18d4_part.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@Table(name = "address", schema = "S18D4")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "street")
    private String street;


    @Column(name = "no")
    private int no;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "description")
    private String description;

    @OneToOne(mappedBy = "address",cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH} )
    private Customer customer;
}
