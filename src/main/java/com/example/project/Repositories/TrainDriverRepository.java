package com.example.project.Repositories;

import com.example.project.Models.TrainDriverModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrainDriverRepository extends JpaRepository<TrainDriverModel, Integer> {
    List<TrainDriverModel> findByName(String name);
    List<TrainDriverModel> findBySurname(String surname);
    List<TrainDriverModel> findByPersonalNumber(String personalNumber);
    List<TrainDriverModel> findByOriginStationId(int originStationId);

    @Modifying
    @Query(value = "UPDATE train_driver SET name = :name, surname= :surname, personal_number = :personalNumber, origin_station_id= :originStationId WHERE train_driver_id= :id", nativeQuery = true)
    void updateTrainDriver(@Param("id") int id, @Param("name") String name, @Param("surname") String surname, @Param("personalNumber") String personalNumber, @Param("originStationId") int originStationId);
}
