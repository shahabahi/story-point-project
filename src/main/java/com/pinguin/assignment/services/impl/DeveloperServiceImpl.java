package com.pinguin.assignment.services.impl;

import com.pinguin.assignment.persistences.data.Developer;
import com.pinguin.assignment.persistences.repository.DeveloperRepository;
import com.pinguin.assignment.services.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {
    @Autowired
    private DeveloperRepository developerRepository;

    @Override
    public List<Developer> getDevelopers() throws Exception {
        return developerRepository.findAll();
    }
}
