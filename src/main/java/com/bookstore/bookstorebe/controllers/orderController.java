package com.bookstore.bookstorebe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import com.bookstore.bookstorebe.models.requestModels.addOrderModel;
import com.bookstore.bookstorebe.service.orderService;

@RestController
@ControllerAdvice
@RequestMapping("/order")
public class orderController{

    @Autowired
    private orderService OrderService;

    @GetMapping(path="/{userid}")
    public ResponseEntity getOrders(@PathVariable("userid") int userid){
        return OrderService.getOrders(userid);
        
    }

    @PostMapping
    public ResponseEntity postOrder(@RequestBody @Valid addOrderModel request){
        return OrderService.postOrders(request);
    }

    @DeleteMapping(path="/{orderid}")
    public ResponseEntity deleteOrder(@PathVariable("orderid") int orderid)
    {
        return OrderService.deleteOrder(orderid);
    }
}
