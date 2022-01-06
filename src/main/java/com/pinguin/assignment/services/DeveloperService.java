package com.pinguin.assignment.services;

import com.pinguin.assignment.persistences.data.Developer;
import java.util.List;

public interface DeveloperService {
    List<Developer> getDevelopers() throws Exception;
}
