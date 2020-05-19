package com.kasundissanayake.stock.dbservice.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "quote")
@Getter
@Setter
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "quote")
    private String quote;

    public Quote() {
    }
    public Quote(String userName, String quote) {
        this.userName = userName;
        this.quote = quote;
    }
}
