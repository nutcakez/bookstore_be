package com.bookstore.bookstorebe.repository;

import javax.transaction.Transactional;

import com.bookstore.bookstorebe.models.dto.bookOrdersModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface bookorderRepository extends JpaRepository<bookOrdersModel,Integer>{
    bookOrdersModel[] findByOrderid(Integer id);
    Integer deleteByorderid(Integer orderid);
}
