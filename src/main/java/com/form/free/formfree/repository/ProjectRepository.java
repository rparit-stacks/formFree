package com.form.free.formfree.repository;


import com.form.free.formfree.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Projects, Long>{

    Projects findByApikey(String apikey);
}
