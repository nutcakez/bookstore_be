package com.bookstore.bookstorebe.models.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookorders")
public class bookOrdersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="orderid")
    private int orderid;

    @Column(name="bookid")
    private int bookId;

    public bookOrdersModel(int orderid,int bookid){
        this.orderid=orderid;
        this.bookId=bookid;
    }

    public bookOrdersModel(){};

    public int getOrderId(){
        return this.orderid;
    }

    public int getBookId(){
        return this.bookId;
    }

    public void setOrderId(int orderid){
        this.orderid=orderid;
    }

    public void setBookId(int bookId){
        this.bookId=bookId;
    }
}
