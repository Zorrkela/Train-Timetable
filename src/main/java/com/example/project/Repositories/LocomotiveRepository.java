package com.example.project.Repositories;

import com.example.project.Models.LocomotiveModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocomotiveRepository extends JpaRepository<LocomotiveModel, Integer> {
    List<LocomotiveModel> findBySeries(int series);
    List<LocomotiveModel> findByNumber(int number);
    List<LocomotiveModel> findByPower(int power);
    List<LocomotiveModel> findByStatus(String status);

    @Modifying
    @Query(value = "UPDATE locomotive SET series = :series, number= :number, power = :power, status= :status WHERE locomotive_id= :id", nativeQuery = true)
    void updateLocomotive(@Param("id") int id, @Param("series") int series, @Param("number") int number, @Param("power") int power, @Param("status") String status);
}
