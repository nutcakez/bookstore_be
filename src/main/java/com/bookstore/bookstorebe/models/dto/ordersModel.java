package com.bookstore.bookstorebe.models.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="orders")
public class ordersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderid")
    private int orderId;

    
    @Column(name="userid")
    private int userid;

    public ordersModel(int userid)
    {
        this.userid=userid;
    }
    
    public ordersModel(){};

    public int getOrderId(){
        return this.orderId;
    }

    public int getUserId(){
        return this.userid;
    }
}
