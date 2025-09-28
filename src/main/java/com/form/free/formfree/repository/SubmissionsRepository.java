package com.form.free.formfree.repository;


import com.form.free.formfree.model.FromSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionsRepository extends JpaRepository<FromSubmission, Long>{

    List<FromSubmission> findByProjectId(Long projectId);
}
