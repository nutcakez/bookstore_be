package com.bookstore.bookstorebe.repository;


import javax.transaction.Transactional;

import com.bookstore.bookstorebe.models.dto.ordersModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface orderRepository extends JpaRepository<ordersModel,Integer>{
    ordersModel[] findByUserid(Integer id);
    Integer deleteByorderId(Integer id);
}
