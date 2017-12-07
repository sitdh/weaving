package com.sitdh.thesis.weaving.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sitdh.thesis.weaving.db.entity.UserInformation;

public interface UserInformationRepository extends JpaRepository<UserInformation, String> {

}
