package com.example.project.Repositories;

import com.example.project.Models.StartStationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StartStationRepository extends JpaRepository<StartStationModel, Integer> {
    Optional<StartStationModel> findById(int id);
    List<StartStationModel> findByStationId(int station_id);
    @Modifying
    @Query(value = "UPDATE start_station SET station_id = :station_id WHERE start_station_id= :id", nativeQuery = true)
    void updateStartStation(@Param("id") int id, @Param("station_id") int station_id);
}
