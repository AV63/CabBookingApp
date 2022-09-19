package org.cabBookingApp.Repository;

import org.cabBookingApp.model.CabDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CabDriverRepository extends JpaRepository<CabDriver, Integer> {

    List<CabDriver> findByName(String name);

}
