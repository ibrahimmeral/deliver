package com.cristianruizblog.loginSecurity.service;

import com.cristianruizblog.loginSecurity.entity.ShortSchedule;
import com.cristianruizblog.loginSecurity.repository.ShortScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortScheduleService {
    @Autowired
    ShortScheduleRepository shortScheduleRepository;


    public ShortSchedule getShortScheduleById(Long id){
        return shortScheduleRepository.findById(id).orElse(null);
    }
    public ShortSchedule saveOrUpdate(ShortSchedule shortSchedule){
        return shortScheduleRepository.save(shortSchedule);
    }
}

