package com.example.project.Repositories;

import com.example.project.Models.LastStationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LastStationRepository extends JpaRepository<LastStationModel, Integer> {
    Optional<LastStationModel> findById(int id);
    List<LastStationModel> findByStationId(int station_id);
    @Modifying
    @Query(value = "UPDATE last_station SET station_id = :station_id WHERE last_station_id= :id", nativeQuery = true)
    void updateLastStation(@Param("id") int id, @Param("station_id") int station_id);
}
