package com.bookstore.bookstorebe.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.bookstore.bookstorebe.models.dto.bookOrdersModel;
import com.bookstore.bookstorebe.models.dto.ordersModel;
import com.bookstore.bookstorebe.models.requestModels.addOrderModel;
import com.bookstore.bookstorebe.repository.bookorderRepository;
import com.bookstore.bookstorebe.repository.orderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class orderService {
    public orderService(){};

    @Autowired
    orderRepository OrderRepository;

    @Autowired
    bookorderRepository BookOrderRepository;

    public ResponseEntity getOrders(int userId){
        HashMap<Integer,List<Integer>> response=new HashMap<Integer,List<Integer>>();
        ordersModel[] results = OrderRepository.findByUserid(userId);
        if(results.length==0){
            HashMap<String,String> errorResponse=new HashMap<String,String>();
            errorResponse.put("message","No user found with this id.");
            return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
        }

        for (ordersModel order: results){
            bookOrdersModel[] bookOrders = BookOrderRepository.findByOrderid(order.getOrderId());
            List<Integer> bookids=new ArrayList<Integer>();
            for(bookOrdersModel bookOrder:bookOrders){
                bookids.add(bookOrder.getBookId());
            }
            response.put(order.getOrderId(),bookids);
        }

        return new ResponseEntity<>(response,HttpStatus.OK);
        
    }

    public ResponseEntity postOrders(addOrderModel request){
        HashMap<String,String> response=new HashMap<String,String>();

        ordersModel model=new ordersModel(request.getUserId());
        ordersModel result=OrderRepository.save(model);

        int orderId=result.getOrderId();
        int [] bookIds=request.getBookIds();

        for (int bookid : bookIds) {
            BookOrderRepository.save(new bookOrdersModel(orderId, bookid));
        }

        response.put("message","Order successfully saved!");
        response.put("OrderId",String.valueOf(orderId));
        response.put("OrderedBooks",Arrays.toString(bookIds));
        return new ResponseEntity<HashMap<String,String>>(response,HttpStatus.OK);
    }

    public ResponseEntity deleteOrder(Integer orderId)
    {
        int linesDeleted=BookOrderRepository.deleteByorderid(orderId);
        if(linesDeleted>0){
            OrderRepository.deleteByorderId(orderId);
        }else{
            return new ResponseEntity<String>("Orderid not found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>("Order deleted. The order consisted "+linesDeleted+" books.",HttpStatus.OK);
    }

}
