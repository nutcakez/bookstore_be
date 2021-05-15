package com.bookstore.bookstorebe.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.bookstore.bookstorebe.models.addOrderModel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class orderService {
    public orderService(){};

    public ResponseEntity<String[]> getOrders(int potato){
        String[] response={"good","good"};
        return new ResponseEntity<String[]>(response,HttpStatus.OK);
    }

    public ResponseEntity postOrders(addOrderModel request){
        HashMap<String,String> response=new HashMap<String,String>();

        response.put("message",String.valueOf(request.id*2));
        return new ResponseEntity<HashMap<String,String>>(response,HttpStatus.OK);
    }


    private boolean postOrderInputCheck(HashMap<String,String> params){

        return true;
    }
}
