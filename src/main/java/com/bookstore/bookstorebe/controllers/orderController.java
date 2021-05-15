package com.bookstore.bookstorebe.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.bookstore.bookstorebe.models.addOrderModel;
import com.bookstore.bookstorebe.service.orderService;

@RestController
@RequestMapping("/order")
public class orderController{
    orderService orderService=new orderService();

    // @GetMapping
    // public ResponseEntity<String[]> getOrders(@RequestParam HashMap<String,String> params){
    //     return orderService.getOrders(params);
    // }

    @PostMapping
    public ResponseEntity postOrder(@Validated @RequestBody addOrderModel request){
        return orderService.postOrders(request);
    }

    @DeleteMapping
    public String deleteOrder()
    {
        return "deleted!";
    }
}
