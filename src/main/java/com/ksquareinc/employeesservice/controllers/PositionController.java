package com.ksquareinc.employeesservice.controllers;

import com.ksquareinc.employeesservice.models.Position;
import com.ksquareinc.employeesservice.models.Position;
import com.ksquareinc.employeesservice.repository.PositionRepository;
import com.ksquareinc.employeesservice.repository.PositionRepository;
import com.ksquareinc.employeesservice.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/position")
public class PositionController {

    @Autowired
    PositionService positionService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Position> findAll(){
        return positionService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Position position) {
        Position result = positionService.save(position);
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Position position) {
        Position result = positionService.save(position);
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody Position position){
        positionService.delete(position);
        return ResponseEntity.ok().body("Deleted position: \n" + position);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findOne(@PathVariable("id") long id){
        Optional<Position> position = positionService.findOne(id);
        if (position.isPresent()){
            Position result = position.get();
            return  ResponseEntity.ok(result);
        }
        return ResponseEntity.status(503).body("Office not found");
    }
}
