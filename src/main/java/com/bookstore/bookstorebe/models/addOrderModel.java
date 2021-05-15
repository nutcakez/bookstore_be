package com.bookstore.bookstorebe.models;

import org.springframework.format.annotation.NumberFormat;

public class addOrderModel {
    @NumberFormat
    public int id;
    public int[] bookIds;

    public addOrderModel(int id, int[] bookIds){
        this.id=id;
        this.bookIds=bookIds;
    }
}
