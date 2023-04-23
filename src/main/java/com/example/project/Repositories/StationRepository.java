package com.example.project.Repositories;

import com.example.project.Models.StationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<StationModel, Integer> {
    List<StationModel> findByName(String name);
    List<StationModel> findByLocation(String location);
    @Modifying
    @Query(value = "UPDATE stations SET name = :name, location= :location WHERE station_id= :id", nativeQuery = true)
    void updateStation(@Param("id") int id, @Param("name") String name, @Param("location") String location);
}
