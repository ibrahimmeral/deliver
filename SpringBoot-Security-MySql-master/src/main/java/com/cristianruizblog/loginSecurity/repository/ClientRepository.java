package com.cristianruizblog.loginSecurity.repository;

import com.cristianruizblog.loginSecurity.entity.Client;
import com.cristianruizblog.loginSecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
