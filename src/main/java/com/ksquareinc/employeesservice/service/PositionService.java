package com.ksquareinc.employeesservice.service;

import com.ksquareinc.employeesservice.models.Position;
import com.ksquareinc.employeesservice.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService {

    @Autowired
    PositionRepository positionRepository;


    public Position save(Position position) {
        return positionRepository.save(position);
    }

    public List<Position> findAll() {
        List<Position> findAll = positionRepository.findAll();
        return findAll;
    }

    public void delete(Position position){
        positionRepository.delete(position);
    }

    public Optional<Position> findOne(long id){
        return positionRepository.findById(id);
    }



}

