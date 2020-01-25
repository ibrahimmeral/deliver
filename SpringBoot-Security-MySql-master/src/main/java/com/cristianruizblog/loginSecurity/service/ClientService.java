package com.cristianruizblog.loginSecurity.service;

import com.cristianruizblog.loginSecurity.entity.Client;
import com.cristianruizblog.loginSecurity.entity.Orders;
import com.cristianruizblog.loginSecurity.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;


    public Client saveOrUpdate(Client client){
        return clientRepository.save(client) ;
    }

    public void delete(Client client){
        clientRepository.deleteById(client.getId());
    }

    public Client getClientById(Long id){
        return clientRepository.findById(id).orElse(null);
    }

    public List<Client> getAllOrders(){
        return clientRepository.findAll();
    }
}
