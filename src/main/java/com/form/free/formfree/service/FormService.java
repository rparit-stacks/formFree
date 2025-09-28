package com.form.free.formfree.service;

import com.form.free.formfree.model.FromSubmission;
import com.form.free.formfree.model.Projects;
import com.form.free.formfree.repository.ProjectRepository;
import com.form.free.formfree.repository.SubmissionsRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service
public class FormService {
    @Autowired
    private SubmissionsRepository submissionsRepository;
    @Autowired
    private ProjectRepository projectRepository;
    private final Gson gson = new Gson();

    // Creates a new project and returns details
    public Map<String, String> createProject(String projectName) {
        Projects project = new Projects();
        project.setProjectName(projectName);
        project.setApikey(UUID.randomUUID().toString());
        projectRepository.save(project);

        Map<String, String> projectDetails = new HashMap<>();
        projectDetails.put("project name", project.getProjectName());
        projectDetails.put("Api key", project.getApikey());
        projectDetails.put("Api Endpoint", "http://localhost:8080/api/form/submit/" + project.getApikey());
        return projectDetails;
    }

    public String submitForm(String apiKey, Map<String, Object> formField) throws Exception {
        Projects project = projectRepository.findByApikey(apiKey);
        if (project == null) {
            throw new Exception("Wrong Api Key");
        }
        String jsonData = gson.toJson(formField);
        FromSubmission submission = new FromSubmission();
        submission.setProjectId(project.getId());
        submission.setSubmissions(jsonData);
        submissionsRepository.save(submission);
        // Submisson saved successfully
        return "Successfully Submitted The Form !!";
    }

    public List<FromSubmission> getSubmissionFromProjectId(Long projectId) {
        return submissionsRepository.findByProjectId(projectId);
    }
}
