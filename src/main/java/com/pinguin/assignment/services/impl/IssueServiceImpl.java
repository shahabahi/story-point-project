package com.pinguin.assignment.services.impl;

import com.pinguin.assignment.persistences.data.Issue;
import com.pinguin.assignment.persistences.repository.IssuesRepository;
import com.pinguin.assignment.persistences.repository.StoriesRepository;
import com.pinguin.assignment.services.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssuesRepository issuesRepository;

    @Override
    public List<Issue> getIssues() throws Exception {
        return issuesRepository.findAll();
    }

    @Override
    public Issue addIssue(Issue issue) throws Exception {
        return issuesRepository.save(issue);
    }
}
