package com.example.project.Repositories;

import com.example.project.Models.TrainModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.util.List;

public interface TrainRepository extends JpaRepository<TrainModel, Integer> {
    List<TrainModel> findByTime(Time time);
    List<TrainModel> findByWeight(int weight);
    List<TrainModel> findByCompositionId(int compositionId);
    List<TrainModel> findByStartStationId(int startStationId);

    List<TrainModel> findByLastStationId(int lastStationId);

    @Modifying
    @Query(value = "UPDATE train SET time_of_departure = :time, weight= :weight, composition_id = :compositionId, start_station_id= :startStationId, last_station_id= :lastStationId WHERE train_number= :id", nativeQuery = true)
    void updateTrain(@Param("id") int id, @Param("time") Time time, @Param("weight") int weight, @Param("compositionId") int compositionId, @Param("startStationId") int startStationId, @Param("lastStationId") int lastStationId);
}
