package org.example.testendmodule4.service;

import org.example.testendmodule4.model.LandManagers;

public interface ILandManagerService {
    Iterable<LandManagers> findAll();
    LandManagers findById(Long id);
    void save(LandManagers landManagers);
    void deleteById(Long id);
    LandManagers finByName(String name);
}
