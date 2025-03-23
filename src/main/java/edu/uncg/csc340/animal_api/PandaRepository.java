package edu.uncg.csc340.animal_api;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PandaRepository extends JpaRepository<Panda, Integer> {
    List<Panda> findByType(String type);
    List<Panda> findByNameContaining(String name);
}
