package com.form.free.formfree.controller;


import com.form.free.formfree.model.FromSubmission;
import com.form.free.formfree.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class FormController {

    @Autowired
    private FormService formService;


    @PostMapping("/create-project")
    public ResponseEntity<Map<String, String>> createProject(@RequestParam String projectName) {
        Map<String, String> projectDetails = formService.createProject(projectName);
        return new ResponseEntity<>(projectDetails, HttpStatus.CREATED);
    }

    @PostMapping("/form/submit/{apiKey}")
    public ResponseEntity<String> submitForm(@PathVariable String apiKey,
                                             @RequestBody Map<String, Object> formField) {
        try {
            String result = formService.submitForm(apiKey, formField);
            return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            // Error handlng
            return new ResponseEntity<>("Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/form/result/{projectId}")
    public List<FromSubmission> getSubmissionFromProjectId(@PathVariable Long projectId) {
        // Fetches all submissions for a project
        return formService.getSubmissionFromProjectId(projectId);
    }
}
