package org.example.testendmodule4.restcontroller;

import org.example.testendmodule4.model.LandManagers;
import org.example.testendmodule4.service.ILandManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/land")
public class LandManagerController {
    @Autowired
    private ILandManagerService landManagerService;
    @GetMapping
    public ResponseEntity<Iterable<LandManagers>> findAll(){
        return new ResponseEntity<>(landManagerService.findAll(), HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<LandManagers> findOne(@PathVariable Long id){
        return new ResponseEntity<>(landManagerService.findById(id),HttpStatus.OK);
    }
    @GetMapping("/{name}")
    public ResponseEntity<LandManagers> findByname(@PathVariable String name){
        return new ResponseEntity<>(landManagerService.finByName(name),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody LandManagers products) {
        landManagerService.save(products);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<LandManagers> edit(@PathVariable Long id, @RequestBody LandManagers landManagers){
        Optional<LandManagers> landManagersOptional = Optional.ofNullable(landManagerService.findById(id));
        if (!landManagersOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            landManagers.setId(id);
            landManagerService.save(landManagers);
            return new ResponseEntity<>(landManagersOptional.get(), HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        landManagerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
