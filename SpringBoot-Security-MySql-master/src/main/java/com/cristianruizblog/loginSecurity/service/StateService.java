package com.cristianruizblog.loginSecurity.service;

import com.cristianruizblog.loginSecurity.entity.Orders;
import com.cristianruizblog.loginSecurity.entity.State;
import com.cristianruizblog.loginSecurity.repository.OrderRepository;
import com.cristianruizblog.loginSecurity.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateService {
    @Autowired
    StateRepository stateRepository;


    public State getStateById(Long id){
        return stateRepository.findById(id).orElse(null);
    }

    public State saveOrUpdate(State state){
        return stateRepository.save(state);
    }
}
