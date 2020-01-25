package com.cristianruizblog.loginSecurity.service;


import com.cristianruizblog.loginSecurity.entity.Orders;
import com.cristianruizblog.loginSecurity.entity.State;
import com.cristianruizblog.loginSecurity.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Orders> getAllOrders(){
        return orderRepository.findAll();
    }

    public List<Orders> getAllOrdersOrderBySaveTime(){
        return orderRepository.findAllOrderBySaveTime();
    }

    public List<Orders> getPreStatusOrdersOrderBySaveTime(){
        return orderRepository.findPreStatusOrdersOrderBySaveTime();
    }


    public List<Orders> getDoneStatusOrdersOrderBySaveTime(){
        return orderRepository.findDoneStatusOrdersOrderBySaveTime();
    }

    public void delete(Orders order){
        orderRepository.deleteById(order.getId());
    }



    public Orders getOrderById(Long id){
        return orderRepository.findById(id).orElse(null);
    }

    public Orders saveOrUpdate(Orders order){
        return orderRepository.save(order);
    }

    public List<Orders> getOrdersByFirmNameAndDoneStatusOrderBySaveTime(String firmName){
        return orderRepository.findOrdersByFirmNameAndDoneStatusOrderBySaveTime(firmName);
        //return null;
    }

    public List<Orders> getOrdersByFirmName(String firmName){
        return orderRepository.findOrdersByFirmName(firmName);
        //return null;
    }
}
