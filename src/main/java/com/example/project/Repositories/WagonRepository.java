package com.example.project.Repositories;

import com.example.project.Models.WagonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WagonRepository extends JpaRepository<WagonModel, Integer> {
    Optional<WagonModel> findByWagonStatus(String status);
    @Modifying
    @Query(value = "UPDATE wagon SET type_of_wagon = :typeOfWagon, status= :status, weight(t) = :weight WHERE wagon_id= :id", nativeQuery = true)
    void updateWagon(@Param("id") int id, @Param("typeOfWagon") String typeOfWagon, @Param("status") String status, @Param("weight") String weight);
}
