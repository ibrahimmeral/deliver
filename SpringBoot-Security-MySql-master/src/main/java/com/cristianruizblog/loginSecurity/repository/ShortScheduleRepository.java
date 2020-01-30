package com.cristianruizblog.loginSecurity.repository;

import com.cristianruizblog.loginSecurity.entity.ShortSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortScheduleRepository extends JpaRepository<ShortSchedule, Long> {
}
