package com.example.project.Repositories;

import com.example.project.Models.CompositionModel;
import com.example.project.Models.StationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompositionRepository extends JpaRepository<CompositionModel, Integer> {
    List<CompositionModel> findByLocomotiveId(int locomotive_id);
    List<CompositionModel> findByWagonId(int wagon_id);

    @Modifying
    @Query(value = "UPDATE composition SET locomotive_id = :locomotive_id, wagon_id= :wagon_id WHERE composition_id= :id", nativeQuery = true)
    void updateComposition(@Param("id") int id, @Param("locomotive_id") int name, @Param("wagon_id") int wagon_id);
}
