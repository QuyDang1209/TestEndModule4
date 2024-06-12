package org.example.testendmodule4.service;

import org.example.testendmodule4.model.LandManagers;
import org.example.testendmodule4.repository.ILandManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LandManagerService implements ILandManagerService {
    @Autowired
    private ILandManagerRepository landManagerRepository;

    @Override
    public Iterable<LandManagers> findAll() {
        return landManagerRepository.findAll();
    }

    @Override
    public LandManagers finByName(String name) {
        return landManagerRepository.findLandManagersByCustomerName(name);
    }

    @Override
    public LandManagers findById(Long id) {
        return landManagerRepository.findById(id).get();
    }

    @Override
    public void save(LandManagers landManagers) {
    landManagerRepository.save(landManagers);
    }

    @Override
    public void deleteById(Long id) {
    landManagerRepository.deleteById(id);
    }
}
