package org.example.testendmodule4.repository;

import org.example.testendmodule4.model.LandManagers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILandManagerRepository extends JpaRepository<LandManagers, Long> {
    LandManagers findLandManagersByCustomerName(String name);
}
