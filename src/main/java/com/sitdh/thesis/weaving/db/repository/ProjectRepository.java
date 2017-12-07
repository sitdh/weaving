package com.sitdh.thesis.weaving.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sitdh.thesis.weaving.db.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
