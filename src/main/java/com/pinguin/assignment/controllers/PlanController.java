package com.pinguin.assignment.controllers;

import com.pinguin.assignment.persistences.data.Story;
import com.pinguin.assignment.services.DeveloperService;
import com.pinguin.assignment.services.StoryService;
import com.pinguin.assignment.utils.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class PlanController {

    @Autowired
    private StoryService storyService;

    @Autowired
    private DeveloperService developerService;

    @GetMapping(value = "/plan",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
            })
    public List<Story> getPlan() throws Exception {
        Plan plan=new Plan();
        return  plan.doPlaning(storyService.getStories(),developerService.getDevelopers());
    }
}
