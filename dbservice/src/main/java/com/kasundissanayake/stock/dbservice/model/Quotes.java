package com.kasundissanayake.stock.dbservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Quotes {

    private String userName;
    private List<String> quotes;

    public Quotes() {
    }

    public Quotes(String userName, List<String> quotes) {
        this.userName = userName;
        this.quotes = quotes;
    }
}
