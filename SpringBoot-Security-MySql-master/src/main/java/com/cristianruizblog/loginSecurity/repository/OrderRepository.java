package com.cristianruizblog.loginSecurity.repository;

import com.cristianruizblog.loginSecurity.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Query("select o from Orders o where o.client.firmName =  :firmName")
    List<Orders> findOrdersByFirmName(String firmName);

    @Query("select o from Orders o where o.client.firmName =  :firmName and o.state.id = 1 order by o.saveTime")
    List<Orders> findOrdersByFirmNameAndDoneStatusOrderBySaveTime(String firmName);

    @Query("select o from Orders o order by o.saveTime")
    List<Orders> findAllOrderBySaveTime();

    @Query("select o from Orders o where o.state.id = 0 order by o.saveTime")
    List<Orders> findPreStatusOrdersOrderBySaveTime();

    @Query("select o from Orders o where o.state.id = 1 order by o.saveTime")
    List<Orders> findDoneStatusOrdersOrderBySaveTime();
}
