package com.pinguin.assignment.controllers;

import com.pinguin.assignment.persistences.data.Issue;
import com.pinguin.assignment.services.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/issues")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @PostMapping(path = "/add")
    public ResponseEntity<Issue> addIssue(@RequestBody Issue issue) {
        try {
            issue.setCreateDate(new Date());
            return new ResponseEntity(issueService.addIssue(issue), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
