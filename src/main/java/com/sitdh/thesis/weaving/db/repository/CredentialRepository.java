package com.sitdh.thesis.weaving.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sitdh.thesis.weaving.db.entity.Credential;

public interface CredentialRepository extends JpaRepository<Credential, Long> {

}
